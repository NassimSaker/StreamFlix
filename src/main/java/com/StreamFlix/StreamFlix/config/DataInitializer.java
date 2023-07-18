package com.StreamFlix.StreamFlix.config;

import com.StreamFlix.StreamFlix.enums.RoleName;
import com.StreamFlix.StreamFlix.models.Role;
import com.StreamFlix.StreamFlix.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepo;

    public DataInitializer(RoleRepository roleRepository){
        this.roleRepo = roleRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        for (RoleName role: RoleName.values()) {
            roleRepo.save(new Role(null, role));
        }
    }
}
