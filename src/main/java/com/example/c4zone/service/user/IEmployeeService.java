package com.example.c4zone.service.user;
import com.example.c4zone.dto.user.employee.EmployeeDto;
import com.example.c4zone.dto.user.employee.IEmployeeDto;
import com.example.c4zone.model.user.AppRole;
import com.example.c4zone.model.user.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {

    /**
     * method :findAllEmployee()
     * created by :PhuocLQ
     * date create: 10/09/2023
     *
     * @param:
     * return: List<AppUser>
     */
    List<AppUser> findAllEmployee();

    /**
     * method :findAllEmployeeBy()
     * created by :PhuocLQ
     * date create: 10/09/2023
     *
     * @param: pageable,searchJob,searchName,searchPhone
     * return: Page<AppUser>
     */
    Page<IEmployeeDto> findAllEmployeeBy(Pageable pageable, String searchJob, String searchName, String searchPhone);

    /**
     * method :deleteEmployeeById()
     * created by :PhuocLQ
     * date create: 10/09/2023
     *
     * @param: id
     * return: void
     */
    void deleteEmployeeById(Long id);

    /**
     * method :getEmployeeById()
     * created by :PhuocLQ
     * date create: 10/09/2023
     *
     * @param: id
     * return: AppUser
     */
    AppUser getEmployeeById(Long id);




    void editUser(AppUser user);
    /**
     * Author: CaoNV
     * Date create: 15/09/2023
     * Get next code of employee
     * @return new code
     */
    String getNextCode();

    /**
     * Author: TanNV
     * Date create: 15/09/2023
     * Save employee
     *
     * @param user

     * @return void
     */
    void createEmployee(AppUser user);
    /**
     * Author: CaoNV
     * Date:12/10/2023
     * update employee
     * @param employee
     */
    void updateEmployee(AppUser employee);
}
