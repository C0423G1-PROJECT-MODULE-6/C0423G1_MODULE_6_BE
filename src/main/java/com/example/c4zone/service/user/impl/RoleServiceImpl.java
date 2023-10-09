package com.example.c4zone.service.user.impl;


import com.example.c4zone.model.user.Role;
import com.example.c4zone.model.user.RoleName;
import com.example.c4zone.repository.user.IRoleRepository;
import com.example.c4zone.service.user.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
