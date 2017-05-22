package com.vladimirstanciu.accessgranter.service;

import com.vladimirstanciu.accessgranter.domain.Permission;
import com.vladimirstanciu.accessgranter.domain.Role;
import com.vladimirstanciu.accessgranter.domain.RolePermission;
import com.vladimirstanciu.accessgranter.domain.UserRole;
import com.vladimirstanciu.accessgranter.repository.PermissionRepository;
import com.vladimirstanciu.accessgranter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * Created by Vladimir on 5/21/2017.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserRepository userRepository;

    public Permission addPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public List<Permission> getPermissions() {
        return permissionRepository.findAll();
    }

    public List<Permission> getActivePermissions(Long id) {
        return permissionRepository.findActivePermissions(id);
    }

    public List<Permission> getAvailablePermissions(Long id) {
        return permissionRepository.findAvailablePermissions(id);
    }

    public List<Permission> getActivePermissionsForUser(Long userId) {
        Set<UserRole> roles = userRepository.findOne(userId).getUserRoles();
        List<Permission> permissions = new ArrayList<>();

        for (UserRole userRole : roles) {
            Role role = userRole.getRole();
            Set<RolePermission> rolePermList = role.getRolePermissions();
            for (RolePermission rolePerm : rolePermList) {
                permissions.add(rolePerm.getPermission());
            }

        }
        return permissions.stream()
                .collect(collectingAndThen(toCollection(() -> new TreeSet<>(comparingLong(Permission::getId))),
                        ArrayList::new));
    }
}
