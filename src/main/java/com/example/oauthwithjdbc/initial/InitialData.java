package com.example.oauthwithjdbc.initial;

import com.example.oauthwithjdbc.repository.RoleRepository;
import com.example.oauthwithjdbc.repository.UserRepository;
import com.example.oauthwithjdbc.entity.Role;
import com.example.oauthwithjdbc.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
public class InitialData implements CommandLineRunner, Serializable {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public InitialData(UserRepository userRepository, RoleRepository roleRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        Role r1 = new Role("ROLE_ADMIN");
        Role r2 = new Role("ROLE_VIP");
        roleRepository.save(r1);
        roleRepository.save(r2);

        String pass = passwordEncoder.encode("123456");
        User u1 = new User("admin", pass);
        User u2 = new User("faisal", pass);
        User u3 = new User("faisal2", pass);
        u1.setRole(r1);
        u2.setRole(r2);
        u3.setRole(r2);
        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);
    }
}