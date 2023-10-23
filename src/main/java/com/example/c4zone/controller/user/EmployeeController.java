package com.example.c4zone.controller.user;

import com.example.c4zone.dto.user.employee.FormatEmployee;
import com.example.c4zone.dto.user.employee.IEmployeeDto;
import com.example.c4zone.model.user.AppRole;
import com.example.c4zone.model.user.AppUser;
import com.example.c4zone.dto.user.employee.EmployeeDto;
import com.example.c4zone.model.user.UserRole;
import com.example.c4zone.repository.user.IUserRoleRepository;
import com.example.c4zone.service.user.IAppRoleService;
import com.example.c4zone.service.user.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/admin/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IAppRoleService appRoleService;
    @Autowired
    private IUserRoleRepository userRoleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * method :findAllEmployeeBy()
     * created by :PhuocLQ
     * date create: 10/09/2023
     *
     * @param: page, searchJob, searchName,searchPhone
     * return: Page<AppUser>
     */
    @GetMapping("/list")
    public ResponseEntity<Page<IEmployeeDto>> findAllEmployeeBy(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                                                @RequestParam(name = "searchJob", defaultValue = "", required = false) String searchJob,
                                                                @RequestParam(name = "searchName", defaultValue = "", required = false) String searchName,
                                                                @RequestParam(name = "searchPhone", defaultValue = "", required = false) String searchPhone) {

        Pageable pageable = PageRequest.of(page,5,Sort.by("id").descending());
        Page<IEmployeeDto> employeeDtoPage = employeeService.findAllEmployeeBy(pageable, '%' + searchJob + '%', "%" + searchName + "%", "%" + searchPhone + "%");
        if (employeeDtoPage.getTotalElements() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employeeDtoPage, HttpStatus.OK);
    }

    /**
     * method :deleteEmployeeById()
     * created by :PhuocLQ
     * date create: 10/09/2023
     *
     * @param: id
     * return: void
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AppUser> deleteEmployeeById(@PathVariable Long id) {
        AppUser user = employeeService.getEmployeeById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            employeeService.deleteEmployeeById(id);
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
     * @param employeeDto   validate
     * @param bindingResult errors
     * @return Response entity
     */
    @Transactional
    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeDto employeeDto, BindingResult bindingResult) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        Map<String, String> errorMap = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()
            ) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(errorMap, HttpStatus.NOT_ACCEPTABLE);
        }
        if (errorMap.size() > 0) {
            return new ResponseEntity<>(errorMap, HttpStatus.NOT_ACCEPTABLE);
        }
        Boolean userNameExisted = employeeService.existsByUsername(employeeDto.getUserName());
        if (Boolean.TRUE.equals(userNameExisted)) {
            errorMap.put("appUser","Tài khoản này đã tồn tại");

        }

        AppUser employee = new AppUser();
        BeanUtils.copyProperties(employeeDto, employee);
        LocalDate date = FormatEmployee.formatDate(employeeDto.getEmployeeStartDate());
        employee.setEmployeeStartDate(date);
        System.err.println(date);
        LocalDate dateBirth = FormatEmployee.formatDate(employeeDto.getEmployeeBirthday());
        employee.setEmployeeBirthday(dateBirth);
        System.err.println(dateBirth);
        AppRole appRole = appRoleService.findById(employeeDto.getRoleId());
        employee.setFlagDeleted(false);
        employee.setPassword(passwordEncoder.encode("123456"));
        employeeService.createEmployee(employee);
        // id appUser
        Long appUser = employeeService.getNextId();

        // id appRole
        Long appRole1 = employeeDto.getRoleId();


        AppRole appRole2 = new AppRole();
        appRole2.setId(appRole1);

        AppUser appUser1 = new AppUser();
        appUser1.setId(appUser);

        UserRole userRole = new UserRole(appUser1, appRole2);

        userRoleRepository.save(userRole);


        return new ResponseEntity<>("Thêm mới thành công", HttpStatus.OK);
    }

    /**
     * Author: CaoNV
     * Date: 12/10/2023
     * Receive data and validate, if there is an error, return BAD_REQUEST,
     * then save the employee to the DB. If saved successfully, return OK
     *
     * @param id            id employee
     * @param employeeDto   validate info
     * @param bindingResult return error
     * @return Responese Entity with message
     */
    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id,
                                                 @Valid @RequestBody EmployeeDto employeeDto,
                                                 BindingResult bindingResult) {
        System.err.println(employeeDto);
        System.err.println(id);
        if (id == null) {
            return new ResponseEntity<>("Không có id", HttpStatus.BAD_REQUEST);
        }
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors().toString(), HttpStatus.NOT_ACCEPTABLE);
        }
        AppUser employee = employeeService.getEmployeeById(id);


        if (employee == null) {
            return new ResponseEntity<>("Không tìm thấy", HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(employeeDto, employee);

        LocalDate date = FormatEmployee.formatDate(employeeDto.getEmployeeStartDate());
        employee.setEmployeeStartDate(date);


        date = FormatEmployee.formatDate(employeeDto.getEmployeeBirthday());
        employee.setEmployeeBirthday(date);


        employeeService.updateEmployee(employee, id,employeeDto.getRoleId());

        return new ResponseEntity<>("Update thành công", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Long id){
        IEmployeeDto employee = employeeService.getEmployeeByIdEdit(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);

    }


}