package com.StreamFlix.StreamFlix.servicesImplem;

import com.StreamFlix.StreamFlix.enums.RoleName;
import com.StreamFlix.StreamFlix.models.Role;
import com.StreamFlix.StreamFlix.models.User;
import com.StreamFlix.StreamFlix.repositories.RoleRepository;
import com.StreamFlix.StreamFlix.repositories.UserRepository;
import com.StreamFlix.StreamFlix.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserImplem implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    JwtService jwtService;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public User createUser(User user) {
        String lastname = user.getLastname();
        String firtname = user.getFirstname();
        String password = user.getPassword();
        String passwordEncoded = passwordEncoder.encode(password);
        user.setLastname(lastname);
        user.setFirstname(firtname);
        user.setPassword(passwordEncoded);
        return userRepository.save(user);
    }

    /*@Override
    public User createUserPremium(User user) {
        String password = user.getPassword();
        String passwordEncoded = passwordEncoder.encode(password);
        user.setPassword(passwordEncoded);
        return userRepository.save(user);
    }

    @Override
    public User createUserClassic(User user) {
        String password = user.getPassword();
        String passwordEncoded = passwordEncoder.encode(password);
        user.setPassword(passwordEncoded);
        return userRepository.save(user);
    }*/

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void addRoleToUser(String email, RoleName roleName) {
        Optional<Role> role = roleRepository.findByName(roleName);
        Optional<User> user = userRepository.findByEmail(email);

        if (role.isPresent() && user.isPresent()){
            user.get().getRoles().add(role.get());
        }
    }

    @Override
    public String login (String email, String password){
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()){
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            email,
                            password
                    )
            );
            return jwtService.generateToken(user.get());
        }
        return "user not found";
    }

}
