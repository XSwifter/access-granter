package com.vladimirstanciu.accessgranter.service;

import com.vladimirstanciu.accessgranter.domain.Role;
import com.vladimirstanciu.accessgranter.domain.User;
import com.vladimirstanciu.accessgranter.domain.UserRole;
import com.vladimirstanciu.accessgranter.repository.RoleRepository;
import com.vladimirstanciu.accessgranter.repository.UserRepository;
import com.vladimirstanciu.accessgranter.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vladimir on 5/21/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    public UserRole addRole(Long userId, Long roleId){

        User user = userRepository.findOne(userId);
        Role role = roleRepository.findOne(roleId);
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        return userRoleRepository.save(userRole);
    }

    public void removeRole(Long userId, Long roleId) {
        UserRole userRole = userRoleRepository.findByUserIdAndRoleId(userId, roleId);
        userRoleRepository.delete(userRole.getId());
    }
}
