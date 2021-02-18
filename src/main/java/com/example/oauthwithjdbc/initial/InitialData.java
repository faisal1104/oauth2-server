package com.example.oauthwithjdbc.initial;

import com.example.oauthwithjdbc.repository.RoleRepository;
import com.example.oauthwithjdbc.repository.UserRepository;
import com.example.oauthwithjdbc.entity.Role;
import com.example.oauthwithjdbc.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.stream.Stream;

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

        Stream.of(r1,r2)
                .filter(s -> !roleRepository.existsByAuthority(s.getAuthority()))
                .map(roleRepository::save)
                .forEach(l-> System.out.print(" "));

        String pass = passwordEncoder.encode("123456");
        User u1 = new User("admin", pass);
        User u2 = new User("faisal", pass);
        User u3 = new User("faisal2", pass);
        u1.setRole(r1);
        u2.setRole(r2);
        u3.setRole(r2);

        Stream.of(u1,u2,u3)
                .filter(s -> !userRepository.existsByUsername(s.getUsername()))
                .map(userRepository::save)
                .forEach(l-> System.out.print(" "));
    }
}