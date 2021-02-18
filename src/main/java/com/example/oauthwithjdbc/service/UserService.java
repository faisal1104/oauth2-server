package com.example.oauthwithjdbc.service;

import com.example.oauthwithjdbc.repository.UserRepository;
import com.example.oauthwithjdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = (User) userRepository.findByUsername(s).orElseThrow(()-> new UsernameNotFoundException("Username or password wrong"));
        return user;
    }
}
