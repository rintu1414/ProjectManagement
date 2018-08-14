package com.sra.projectmanagement.repository;

import com.sra.projectmanagement.model.Role;
import com.sra.projectmanagement.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
