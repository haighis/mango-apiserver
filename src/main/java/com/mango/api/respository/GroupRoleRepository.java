package com.mango.api.respository;

import com.mango.api.entities.GroupRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRoleRepository extends JpaRepository<GroupRole, Long> {

    Optional<GroupRole> findByCode(String code);
}
