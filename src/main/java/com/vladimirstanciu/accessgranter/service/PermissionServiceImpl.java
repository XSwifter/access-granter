package com.vladimirstanciu.accessgranter.service;

import com.vladimirstanciu.accessgranter.domain.Permission;
import com.vladimirstanciu.accessgranter.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vladimir on 5/21/2017.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public Permission addPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public List<Permission> getPermissions() {
        return permissionRepository.findAll();
    }
}
