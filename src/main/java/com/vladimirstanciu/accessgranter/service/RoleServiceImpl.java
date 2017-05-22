package com.vladimirstanciu.accessgranter.service;

import com.vladimirstanciu.accessgranter.domain.Permission;
import com.vladimirstanciu.accessgranter.domain.Role;
import com.vladimirstanciu.accessgranter.domain.RolePermission;
import com.vladimirstanciu.accessgranter.repository.PermissionRepository;
import com.vladimirstanciu.accessgranter.repository.RolePermissionRepository;
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

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role findById(Long id) {
        return roleRepository.findOne(id);
    }

    public List<Role> getActiveRoles(Long id){
        return roleRepository.findActiveRoles(id);
    }

    public List<Role> getAvailableRoles(Long id){
        return roleRepository.findAvailableRoles(id);
    }

    public RolePermission addPermission(Long roleId, Long permId){

        Role role = roleRepository.findOne(roleId);
        Permission perm = permissionRepository.findOne(permId);
        RolePermission rolePerm = new RolePermission();
        rolePerm.setRole(role);
        rolePerm.setPermission(perm);
        return rolePermissionRepository.save(rolePerm);
    }

    public void removePermission(Long roleId, Long permId) {
        RolePermission rolePerm = rolePermissionRepository.findByRoleIdAndPermId(roleId, permId);
        rolePermissionRepository.delete(rolePerm.getId());
    }
}
