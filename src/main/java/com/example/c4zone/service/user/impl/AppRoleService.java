package com.example.c4zone.service.user.impl;
import com.example.c4zone.model.user.AppRole;
import com.example.c4zone.repository.user.IAppRoleRepository;
import com.example.c4zone.service.user.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppRoleService implements IAppRoleService {
    @Autowired
    private IAppRoleRepository appRoleRepository;
    @Override
    public List<AppRole> findAllAppRole() {
        return appRoleRepository.getAllRole();
    }

    @Override
    public AppRole findById(Long id) {
        return appRoleRepository.findById(id);
    }
}
