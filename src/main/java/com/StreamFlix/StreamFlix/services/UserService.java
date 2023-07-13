package com.StreamFlix.StreamFlix.services;

import com.StreamFlix.StreamFlix.enums.RoleName;
import com.StreamFlix.StreamFlix.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser (User user);
    List<User> getAllUser();
    Optional<User> getUserByEmail(String email);
    void addRoleToUser (String email, RoleName roleName);
    String login (String email, String password);

}
