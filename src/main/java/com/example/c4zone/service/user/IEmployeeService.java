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
    void createUser(AppUser user);
    void editUser(AppUser user);
}
