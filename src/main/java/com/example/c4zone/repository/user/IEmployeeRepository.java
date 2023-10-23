package com.example.c4zone.repository.user;

import com.example.c4zone.dto.user.employee.EmployeeDto;
import com.example.c4zone.dto.user.employee.IEmployeeDto;
import com.example.c4zone.model.user.AppRole;
import com.example.c4zone.model.user.AppUser;
import com.example.c4zone.model.user.AppUser;
import org.hibernate.query.NativeQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<AppUser, Long> {

    /**
     * method :findAllEmployee()
     * created by :PhuocLQ
     * date create: 10/09/2023
     *
     * @param: return Page<User>
     */
    @Query(nativeQuery = true, value = " SELECT app_user.id as id, app_user.employee_Name as employeeName, app_user.employee_Image as employeeImage, app_user.employee_Birthday as employeeBirthday, app_user.employee_Address as employeeAddress, app_role.type as employeeTypeName , app_user.employee_Phone as employeePhone FROM app_user  " +
            "             JOIN user_role on app_user.id = user_role.app_user_id  " +
            "             JOIN app_role on user_role.app_role_id = app_role.id  " +
            "             where app_user.flag_deleted = 0 and app_role.type like :searchJob and app_user.employee_name like :searchName and app_user.employee_phone like :searchPhone ")
    Page<IEmployeeDto> findAllEmployee(Pageable pageable, @Param("searchJob") String searchJob, @Param("searchName") String searchName, @Param("searchPhone") String searchPhone);

    /**
     * method :deleteEmployeeById()
     * created by :PhuocLQ
     * date create: 10/09/2023
     *
     * @param: id
     * void
     */
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = " UPDATE app_user " +
            " SET flag_deleted = true " +
            " WHERE app_user.id = :id ")
    void deleteEmployeeById(@Param("id") Long id);

    /**
     * method :findEmployeeById()
     * created by :PhuocLQ
     * date create: 10/09/2023
     *
     * @param: id
     * return: user
     */
    @Query(nativeQuery = true, value = " select  * from app_user where id= :id")
    AppUser findEmployeeById(@Param("id") Long id);


    /**
     * Author: CaoNV
     * Date: 12/10/2023
     * Get code of employee latest
     *
     * @return code of employee latest
     */
    @Query(value = "select employee_code from app_user where id = (select max(id) from app_user) and flag_deleted = false", nativeQuery = true)
    String getLastCodeEmployee();

    /**
     * Author: CaoNV
     * Date: 12/10/2023
     * Get code of employee latest
     *
     * @return code of employee latest
     */
    @Query(value = "select max(id) from app_user ", nativeQuery = true)
    Long getLastIdEmployee();

    /**
     * Author: CaoNV
     * Date: 16/09/2023
     * Use to update employee
     *
     * @param employee
     * @param id
     * @return void
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE `c4_zone`.`app_user` \n" +
            "SET \n" +
            "    `email` = :#{#employee.email},\n" +
            "    `employee_address` = :#{#employee.employeeAddress},\n" +
            "    `employee_birthday` = :#{#employee.employeeBirthday},\n" +
            "    `employee_code` = :#{#employee.employeeCode},\n" +
            "    `employee_gender` = :#{#employee.employeeGender},\n" +
            "    `employee_id_card` = :#{#employee.employeeIdCard},\n" +
            "    `employee_image` = :#{#employee.employeeImage} ,\n" +
            "    `employee_name` = :#{#employee.employeeName},\n" +
            "    `employee_phone` = :#{#employee.employeePhone},\n" +
            "    `employee_start_date` = :#{#employee.employeeStartDate},\n" +
            "    `user_name` = :#{#employee.userName}\n" +
            " WHERE " +
            "    `app_user`.`id` = :id AND flag_deleted = FALSE", nativeQuery = true)
    void updateEmployee(@Param(value = "employee") AppUser employee,
                        @Param(value = "id") Long id
    );
    /**
     * Author: CaoNV
     * Date: 16/09/2023
     * Used to create employee
     *
     * @param employee
     * @return void
     */
    @Transactional
    @Query(value = " INSERT INTO app_user (email,employee_address,employee_birthday,employee_code,employee_gender,employee_id_card,employee_image,employee_name,employee_phone,employee_start_date,flag_deleted,`password`,user_name) " +
            " VALUES ( :#{#employee.email},:#{#employee.employeeAddress},:#{#employee.employeeBirthday},:#{#employee.employeeCode},:#{#employee.employeeGender},:#{#employee.employeeIdCard},:#{#employee.employeeImage},:#{#employee.employeeName}, :#{#employee.employeePhone},:#{#employee.employeeStartDate}, :#{#employee.flagDeleted}, :#{#employee.password}, :#{#employee.userName})", nativeQuery = true)
    void createEmployee(@Param(value = "employee") AppUser employee

    );
}