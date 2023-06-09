package com.mango.api.services;


import com.mango.api.entities.GroupRole;
import com.mango.api.entities.User;

import java.util.List;
import java.util.Optional;

/**
 * <h2>UserService</h2>
 *
 * @author aek
 * <p>
 * Description:
 */
public interface UserService {

    /**
     * @param usernameValue username or email
     * @return Optional User
     */
    Optional<User> getUserByUsername(String usernameValue);

    /**
     * @param user ussr object
     * @return user saved or updated
     */
    User save(User user);

    /**
     * @return list of User
     */
    List<User> getUsers();

    Optional<User> getById(String id);

    Optional<GroupRole> getGroupRoleByCode(String code);
}
