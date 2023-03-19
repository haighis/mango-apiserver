package com.mango.api.respository;

import com.mango.api.model.ApplicationShell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApplicationShellRepository extends JpaRepository<ApplicationShell, UUID> {
}
