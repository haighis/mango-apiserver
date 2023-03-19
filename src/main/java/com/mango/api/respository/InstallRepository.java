package com.mango.api.respository;

import com.mango.api.model.Install;
import com.mango.api.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InstallRepository extends JpaRepository<Install, UUID> {
    List<Install> findByName(String name);
}
