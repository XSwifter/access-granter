package com.vladimirstanciu.accessgranter.service;

import com.vladimirstanciu.accessgranter.domain.Role;
import com.vladimirstanciu.accessgranter.domain.RolePermission;

import java.util.List;

/**
 * Created by Vladimir on 5/21/2017.
 */
public interface RoleService {

    Role addRole(Role role);

    List<Role> getRoles();

    Role findById(Long id);

    List<Role> getActiveRoles(Long id);

    List<Role> getAvailableRoles(Long id);

    RolePermission addPermission(Long roleId, Long permId);

    void removePermission(Long roleId, Long permId);
}
