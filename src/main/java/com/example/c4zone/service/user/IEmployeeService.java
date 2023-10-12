package com.example.c4zone.service.user;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<User> findAllUser();
    Page<User> findAllUserBy(Pageable pageable, String searchJob, String searchName, String searchPhone);
    void deleteUserById(Long id);
    User getUserById(Long id);
    void createUser(User user);
    void editUser(User user);
}
