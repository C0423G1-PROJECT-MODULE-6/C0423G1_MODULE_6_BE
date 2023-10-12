package com.example.c4zone.repository.user;
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

@Repository
public interface IEmployeeRepository extends JpaRepository<AppUser,Long> {

    /**
     * method :findAllUserBy()
     * created by :PhuocLQ
     * date create: 10/09/2023
     *
     * @param:
     * return Page<User>
     */
    @Query(nativeQuery = true,value = "SELECT app_user.* FROM app_user  " +
            "             JOIN user_role on app_user.id = user_role.app_user_id  " +
            "             JOIN app_role on user_role.app_role_id = app_role.id  " +
            "             where app_user.flag_deleted = 0 and app_role.name like :searchJob and app_user.employee_name like :searchName and app_user.employee_phone like :searchPhone ")
    Page<AppUser> findAllEmployee(Pageable pageable, @Param("searchJob") String searchJob,@Param("searchName") String searchName,@Param("searchPhone") String searchPhone);

    /**
     * method :deleteUserById()
     * created by :PhuocLQ
     * date create: 10/09/2023
     *
     * @param: id
     * void
     */
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = " UPDATE app_user " +
            " SET flag_deleted = true " +
            " WHERE app_user.id = :id ")
    void deleteUserById(@Param("id") Long id);

    /**
     * method :getUserById()
     * created by :PhuocLQ
     * date create: 10/09/2023
     *
     * @param: id
     * return: user
     */
    @Query(nativeQuery = true,value = " select  * from app_user where id= :id")
    AppUser findUserById(@Param("id") Long id);




    /**
     * Author: CaoNV
     * Date: 12/10/2023
     * Get code of employee latest
     * @return  code of employee latest
     */
    @Query(value = "select employee_code from users where id = (select max(id) from users) and flag_delete = false",nativeQuery = true)
    String getLastCodeEmployee();

    /**
     * Author: CaoNV
     * Date: 16/09/2023
     * Use to update employee
     * @param employee
     * @param id
     * @return void
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE `c4_zone`.`employee` SET `address` = :#{#employee.address}, `birthday` = :#{#employee.birthday}, `id_card` = :#{#employee.idCard}, `image` = :#{#employee.image}, `name_employee` = :#{#employee.nameEmployee}, `note` = :#{#employee.note}, `phone_number` = :#{#employee.phoneNumber}, `start_day` = :#{#employee.startDay} WHERE (`id` = :id) and flag_delete = false",nativeQuery = true)
    void updateEmployee(@Param(value = "employee")AppUser employee,
                        @Param(value = "id") Long id
    );
}
