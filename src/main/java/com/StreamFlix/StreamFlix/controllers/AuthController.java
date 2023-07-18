package com.StreamFlix.StreamFlix.controllers;

import com.StreamFlix.StreamFlix.enums.RoleName;
import com.StreamFlix.StreamFlix.models.User;
import com.StreamFlix.StreamFlix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/auth")
@RestController
public class AuthController {
    @Autowired
    UserService userService;

    @PostMapping("/sign-up-user")
    public void createUser (@RequestBody User user){
        User result = userService.createUser(user);
        userService.addRoleToUser(result.getEmail(), RoleName.USER);
    }
    /*@PostMapping("/sign-up-user-classic")
    public void createUserClassic (@RequestBody User user){
        User result = userService.createUserClassic(user);
        userService.addRoleToUser(result.getEmail(), RoleName.USER_CLASSIC);
    }

    @PostMapping("/sign-up-user-premium")
    public void createUserPremium (@RequestBody User user){
        User result = userService.createUserPremium(user);
        userService.addRoleToUser(result.getEmail(), RoleName.USER_PREMIUM);
    }*/
    @PostMapping("/sign-up-admin")
    public void createAdmin (@RequestBody User user){
        User result = userService.createUser(user);
        userService.addRoleToUser(result.getEmail(), RoleName.ADMIN);
    }
    @PostMapping ("/login")
    public String login (@RequestBody Map<String, String> request){
        return userService.login(request.get("email"), request.get("password"));
    }
}
