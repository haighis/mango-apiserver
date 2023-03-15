package com.mango.appsapi.respository;

import com.mango.appsapi.model.ApplicationShell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationShellRepository extends JpaRepository<ApplicationShell, Long> {
}
