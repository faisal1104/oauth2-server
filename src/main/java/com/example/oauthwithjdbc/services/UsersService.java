package com.example.oauthwithjdbc.services;

import com.example.oauthwithjdbc.Repository.UsersRepository;
import com.example.oauthwithjdbc.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = (Users) usersRepository.findByUsername(s).orElseThrow(()-> new UsernameNotFoundException("Username or password wrong"));
//        Users user = usersRepository.findByUsername(s);
        return user;
    }
}
