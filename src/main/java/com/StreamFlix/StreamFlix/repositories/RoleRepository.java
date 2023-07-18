package com.StreamFlix.StreamFlix.repositories;


import com.StreamFlix.StreamFlix.enums.RoleName;
import com.StreamFlix.StreamFlix.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role save (Role role);
    Optional<Role> findByName(RoleName name);
}
