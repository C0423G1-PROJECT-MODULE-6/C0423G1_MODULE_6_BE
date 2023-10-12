package com.example.c4zone.controller.user;
import com.example.c4zone.model.user.AppUser;
import com.example.c4zone.dto.user.employee.EmployeeDto;
import com.example.c4zone.service.user.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("api/admin/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @GetMapping("/list")
    public ResponseEntity<Page<AppUser>> displayAllUser(@RequestParam(name = "page", defaultValue = "0",required = false) int page,
                                                        @RequestParam(name = "searchJob", defaultValue = "",required = false)String searchJob,
                                                        @RequestParam(name = "searchName",defaultValue = "",required = false)String searchName,
                                                        @RequestParam(name = "searchPhone",defaultValue = "",required = false)String searchPhone){
        Pageable pageable = PageRequest.of(page,5);
        Page<AppUser> userPage = employeeService.findAllUserBy(pageable,"%"+searchJob+"%","%"+searchName+"%","%"+searchPhone+"%");
        if (userPage.getTotalElements()==0 ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userPage, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AppUser> deleteUserById(@PathVariable Long id){
        System.out.println(id);
        AppUser user = employeeService.getUserById(id);
        if (user==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            employeeService.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    /**
     * Author: CaoNV
     * Date: 12/10/2023
     * Used to get employee DTO and reset the new code then return an empty employee with the latest code
     *
     * @return Response entity
     */
    @GetMapping("/create")
    public ResponseEntity<EmployeeDto> getEmployeeToCreate() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeCode(employeeService.getNextCode());
        employeeDto.setEmployeeImage("https://i.bloganchoi.com/bloganchoi.com/wp-content/uploads/2022/02/avatar-trang-y-nghia.jpeg?fit=512%2C20000&quality=95&ssl=1");
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    /**
     * Author: CaoNV
     * Date: 12/10/2023
     * Receive data and validate, if there is an error, return BAD_REQUEST,
     * then save the employee to the DB. If saved successfully, return OK, otherwise NO_CONTENT
     *
     * @param employeeDto validate
     * @param bindingResult errors
     * @return Response entity
     */
    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDto employeeDto, BindingResult bindingResult) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        Map<String, String> errorMap= new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError: bindingResult.getFieldErrors()
            ) {
                errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(errorMap,HttpStatus.NOT_ACCEPTABLE);
        }
        if(errorMap.size()>0){
            return new ResponseEntity<>(errorMap,HttpStatus.NOT_ACCEPTABLE);
        }

        AppUser employee = new AppUser();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.createEmployee(employee);

        return new ResponseEntity<>("Thêm mới thành công", HttpStatus.OK);
    }

}
