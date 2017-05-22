package com.vladimirstanciu.accessgranter.service;

import com.vladimirstanciu.accessgranter.domain.User;
import com.vladimirstanciu.accessgranter.domain.UserRole;

import java.util.List;

/**
 * Created by Vladimir on 5/21/2017.
 */
public interface UserService {

    User addUser(User user);

    List<User> getUsers();

    User findById(Long id);

    UserRole addRole(Long userId, Long roleId);

    void removeRole(Long userId, Long roleId);
}
