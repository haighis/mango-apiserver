package com.mango.api.respository;

import com.mango.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository for the {@link User} JPA entity. Any custom methods, not
 * already defined in {@link JpaRepository}, are to be defined here
 */
public interface UserRepository extends JpaRepository<User, UUID> {

	@Query("SELECT u FROM app_user u WHERE u.username = :username AND u.enabled = true")
	Optional<User> findActiveByUsername(@Param("username") String username);

	@Query("SELECT u FROM app_user u WHERE u.email = :email AND u.enabled = true")
	Optional<User> findActiveByEmail(@Param("email") String email);
}
