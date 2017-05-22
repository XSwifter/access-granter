package com.vladimirstanciu.accessgranter.service;

import com.vladimirstanciu.accessgranter.domain.Permission;

import java.util.List;

/**
 * Created by Vladimir on 5/21/2017.
 */
public interface PermissionService {

    Permission addPermission(Permission permission);

    List<Permission> getPermissions();

    List<Permission> getActivePermissions(Long id);

    List<Permission> getAvailablePermissions(Long id);
}
