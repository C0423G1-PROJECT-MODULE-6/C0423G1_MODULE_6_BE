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
    @Query(nativeQuery = true,value = "SELECT users.name, users.employee_birthday, users.employee_address, roles.name, users.employee_phone FROM users\n " +
            " JOIN user_role on users.id = user_role.user_id\n " +
            " Join roles on user_role.role_id = roles.id\n " +
            " where users.flag_delete = 0 and roles.name like :searchJob and users.name like :searchName and users.employee_phone like :searchPhone; ")
    Page<AppUser> findAllBy(Pageable pageable, @Param("searchJob") String searchJob,@Param("searchName") String searchName,@Param("searchPhone") String searchPhone);

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
    @Query(nativeQuery = true,value = " UPDATE users\n " +
            " SET flag_delete = false\n " +
            " WHERE users.id = :id; ")
    void deleteUserById(@Param("id") Long id);

    /**
     * method :getUserById()
     * created by :PhuocLQ
     * date create: 10/09/2023
     *
     * @param: id
     * return: user
     */
    @Query(nativeQuery = true,value = " select  * from users where id= :id")
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
