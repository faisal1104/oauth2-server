package com.example.oauthwithjdbc.repository;

import com.example.oauthwithjdbc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<UserDetails> findByUsername(String s);
}
