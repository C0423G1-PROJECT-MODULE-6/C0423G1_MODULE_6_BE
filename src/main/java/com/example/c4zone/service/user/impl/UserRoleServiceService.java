package com.example.c4zone.service.user.impl;

import com.example.c4zone.model.user.UserRole;
import com.example.c4zone.repository.user.IUserRoleRepository;
import com.example.c4zone.service.user.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceService implements IUserRoleService {
@Autowired
private IUserRoleRepository userRoleRepository;
    @Override
    public void createUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }
}
