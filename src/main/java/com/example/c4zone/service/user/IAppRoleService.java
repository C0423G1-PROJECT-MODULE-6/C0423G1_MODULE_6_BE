package com.example.c4zone.service.user;
import com.example.c4zone.model.user.AppRole;
import java.util.List;

public interface IAppRoleService {
    List<AppRole> findAllAppRole();
    AppRole findById(Long id);
}
