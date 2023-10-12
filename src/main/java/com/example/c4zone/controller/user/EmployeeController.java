package com.example.c4zone.controller.user;
import com.example.c4zone.model.user.AppUser;
import com.example.c4zone.service.user.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Pageable pageable = PageRequest.of(page,5, Sort.by(Sort.Order.desc("id")));
        Page<AppUser> userPage = employeeService.findAllUserBy(pageable,searchJob,searchName,searchPhone);
        if (userPage.getTotalElements()==0 ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userPage, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AppUser> deleteUserById(@PathVariable Long id){
        AppUser user = employeeService.getUserById(id);
        if (user==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            employeeService.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
