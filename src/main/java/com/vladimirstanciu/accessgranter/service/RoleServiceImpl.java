package com.vladimirstanciu.accessgranter.service;

import com.vladimirstanciu.accessgranter.domain.Role;
import com.vladimirstanciu.accessgranter.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vladimir on 5/21/2017.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public List<Role> getActiveRoles(Long id){
        return roleRepository.findActiveRoles(id);
    }

    public List<Role> getAvailableRoles(Long id){
        return roleRepository.findAvailableRoles(id);
    }
}
