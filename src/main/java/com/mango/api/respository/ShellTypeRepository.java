package com.mango.api.respository;

import com.mango.api.model.ShellType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShellTypeRepository extends JpaRepository<ShellType, UUID> {
}
