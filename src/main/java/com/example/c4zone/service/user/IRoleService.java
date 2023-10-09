package com.example.c4zone.service.user;




import com.example.c4zone.model.user.Role;
import com.example.c4zone.model.user.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
