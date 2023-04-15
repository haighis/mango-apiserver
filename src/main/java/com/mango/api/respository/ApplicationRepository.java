package com.mango.api.respository;

import com.mango.api.model.Application;
import com.mango.api.model.ApplicationShell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, UUID> {
    List<Application> findByApplicationName(String applicationName);
    List<Application> findByApplicationNameAndInstalledInstanceCode(String applicationName, String installedInstanceCode);
}
