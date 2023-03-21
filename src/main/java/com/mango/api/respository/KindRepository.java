package com.mango.api.respository;

import com.mango.api.model.Kind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KindRepository extends JpaRepository<Kind, UUID> {
}
