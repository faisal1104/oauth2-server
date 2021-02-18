package com.example.oauthwithjdbc.initial;

import com.example.oauthwithjdbc.Repository.PermissionRepository;
import com.example.oauthwithjdbc.Repository.RolesRepository;
import com.example.oauthwithjdbc.Repository.UsersRepository;
import com.example.oauthwithjdbc.entity.Permission;
import com.example.oauthwithjdbc.entity.Roles;
import com.example.oauthwithjdbc.entity.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@Component
public class InitialData implements CommandLineRunner, Serializable {
    private final UsersRepository usersRepository;
    private final RolesRepository rolesRepository;
    private final PermissionRepository permissionRepository;
    private final PasswordEncoder passwordEncoder;

    public InitialData(UsersRepository usersRepository, RolesRepository rolesRepository, PermissionRepository permissionRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.rolesRepository = rolesRepository;
        this.permissionRepository = permissionRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Permission> permissionList = Stream.of("create_user", "update_user", "delete_user")
                .map(Permission::new)
                .map(permissionRepository::save)
                .collect(Collectors.toList());

        Roles r1 = new Roles("ROLE_ADMIN");
        Roles r2 = new Roles("ROLE_VIP");
        r1.setPermissions(Stream.of(permissionList.get(0), permissionList.get(1), permissionList.get(2))
                .collect(Collectors.toList()));
        r2.setPermissions(Stream.of(permissionList.get(0)).collect(Collectors.toList()));

        rolesRepository.save(r1);
        rolesRepository.save(r2);

        String pass = passwordEncoder.encode("123456");
        Users u1 = new Users("admin", pass);
        Users u2 = new Users("faisal", pass);
        Users u3 = new Users("faisal2", pass);
        u1.setRoles(r1);
        u2.setRoles(r2);
        u3.setRoles(r2);
        usersRepository.save(u1);
        usersRepository.save(u2);
        usersRepository.save(u3);
    }
}

//        String pass3 = passwordEncoder.encode("666666");
//        Clients clients = new Clients("abc", pass3,"READ",3600,3600, "password" );
//        clientsRepository.save(clients);
//(String clientId, String clientSecret, Set<String> registeredRedirectUri,Set<String> scope,Integer accessTokenValiditySeconds,
// Integer refreshTokenValiditySeconds, Set<String> resourceIds, Set<String> authorizedGrantTypes)
// List<GrantedAuthority> authorities, Map<String, Object> additionalInformation, String autoapprove
//Set<String> uri = Stream.of("http://localgost:8880/get").collect(Collectors.toSet());
//    Set<String> scope = Stream.of("READ","WRITE").collect(Collectors.toSet());
//    Set<String> rId = Stream.of("bs23").collect(Collectors.toSet());
//    Set<String> grantType = Stream.of("password").collect(Collectors.toSet());
