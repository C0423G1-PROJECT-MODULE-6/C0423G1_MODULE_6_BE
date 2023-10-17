package com.example.c4zone.repository.user;
import com.example.c4zone.model.user.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IAppRoleRepository extends JpaRepository<AppRole,Integer> {
    @Query(nativeQuery = true,value = "select * from app_role")
    List<AppRole> getAllRole();
}
