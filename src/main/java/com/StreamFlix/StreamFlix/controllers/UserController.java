package com.StreamFlix.StreamFlix.controllers;

import com.StreamFlix.StreamFlix.models.User;
import com.StreamFlix.StreamFlix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/getUserName")
    public String getName (Authentication authentication){
        return authentication.getName();
    }

    @GetMapping("/getRoles")
    public List<String> getRoles (Authentication authentication){
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority grantedAuthority :authentication.getAuthorities()){
            roles.add(grantedAuthority.getAuthority());
        }
        return roles;
    }
}
