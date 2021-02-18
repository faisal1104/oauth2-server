package com.example.oauthwithjdbc.Repository;

import com.example.oauthwithjdbc.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {

    Optional<UserDetails> findByUsername(String s);
}
