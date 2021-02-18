package com.example.oauthwithjdbc.controller;

import com.example.oauthwithjdbc.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/get")
    public String get(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hi  "+user.getUsername() +". Thanks for login....";
    }
}
