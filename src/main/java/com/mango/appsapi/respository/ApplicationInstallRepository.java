package com.mango.appsapi.respository;

import com.mango.appsapi.model.ApplicationInstall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationInstallRepository extends JpaRepository<ApplicationInstall, Long> {
}
