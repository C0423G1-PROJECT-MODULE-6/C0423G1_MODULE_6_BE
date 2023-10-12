package com.example.c4zone.service.user;

import com.example.c4zone.model.user.AppUser;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<AppUser> findAllUser();
    Page<AppUser> findAllUserBy(Pageable pageable, String searchJob, String searchName, String searchPhone);
    void deleteUserById(Long id);
    AppUser getUserById(Long id);

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
