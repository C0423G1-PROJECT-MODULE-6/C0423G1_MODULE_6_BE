package com.example.c4zone.repository.user;


import com.example.c4zone.model.user.Role;
import com.example.c4zone.model.user.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
   Optional<Role> findByName(RoleName name);
}
