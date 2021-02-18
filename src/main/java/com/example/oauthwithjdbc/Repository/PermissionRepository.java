package com.example.oauthwithjdbc.Repository;

import com.example.oauthwithjdbc.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,Long> {

    boolean existsByName(String name);
}
