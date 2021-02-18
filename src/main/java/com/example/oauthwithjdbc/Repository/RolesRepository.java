package com.example.oauthwithjdbc.Repository;

import com.example.oauthwithjdbc.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles,Long> {
}