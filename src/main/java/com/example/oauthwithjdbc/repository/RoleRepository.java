package com.example.oauthwithjdbc.repository;

import com.example.oauthwithjdbc.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    boolean existsByAuthority(String s);
}