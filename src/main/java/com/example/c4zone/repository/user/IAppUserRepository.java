package com.example.c4zone.repository.user;



import com.example.c4zone.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {


    @Transactional()
    @Query(value = "select * from app_user where user_name = :name and flag_deleted = 0 ", nativeQuery = true)
    AppUser findAppUserByName(@Param("name") String userName);

    @Transactional()
    @Query(value = "select * from app_user where id = :id and flag_deleted = 0 ", nativeQuery = true)
    AppUser findAppUserById(@Param("id") Long id);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO app_user (user_name, password,flag_online, flag_deleted)\n" +
            "VALUES (:#{#appUser.userName},:#{#appUser.password}, 0, 0)", nativeQuery = true)
    Integer addNewAppUser(AppUser appUser);

    @Modifying
    @Transactional
    @Query(value = "update app_user set flag_online = 1 where id = :#{#appUser.id} ",nativeQuery = true)
    Integer updateAppUserIsOnline(AppUser appUser);

    @Modifying
    @Transactional
    @Query(value = "update app_user set flag_online = 0 where user_name = :userName ",nativeQuery = true)
    Integer updateAppUserIsOffline(@Param("userName") String userName);

    @Query(value = " select au.id from app_user au where au.user_name = :userName ",nativeQuery = true)
    Long findIdByUserName(@Param("userName") String userName);

    @Query(value =  " select r.id from app_role r where r.name = :name " ,nativeQuery = true)
    Long findAppRoleIdByName(@Param("name")String name);

    @Modifying
    @Transactional
    @Query(value = " insert into user_role (app_role_id, app_user_id) values (:appRoleId, :appUserId)",nativeQuery = true)
    void insertRoleForCustomer(@Param("appRoleId") Long appRoleId,@Param("appUserId") Long appUserId);

    @Override
    boolean existsById(Long aLong);

    Optional<AppUser> findAppUserByUserName(String name);

    @Modifying
    @Transactional
    @Query(value = "update app_user " +
            "set " +
            "one_time_password = :#{#appUser.oneTimePassword}, " +
            "otp_requested_time = :#{#appUser.otpRequestedTime} " +
            "where id = :#{#appUser.id} ",nativeQuery = true)
    void updateOtp(AppUser appUser);

    @Modifying
    @Transactional
    @Query(value = "update app_user " +
            "set " +
            "employee_address = :#{#appUser.employeeAddress}, " +
            "employee_birthday = :#{#appUser.employeeBirthday}, " +
            "employee_name = :#{#appUser.employeeName}, " +
            "employee_phone = :#{#appUser.employeePhone}, " +
            "email = :#{#appUser.email} " +
            "where id = :#{#appUser.id} ",nativeQuery = true)
    void updateInfoUser(AppUser appUser);

    @Modifying
    @Transactional
    @Query(value = "update app_user " +
            "set " +
            "password = :#{#appUser.password} " +
            "where id = :#{#appUser.id} ",nativeQuery = true)
    void updatePass(AppUser appUser);
}
