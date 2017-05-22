package com.vladimirstanciu.accessgranter.service;

import com.vladimirstanciu.accessgranter.domain.Role;

import java.util.List;

/**
 * Created by Vladimir on 5/21/2017.
 */
public interface RoleService {

    Role addRole(Role role);

    List<Role> getRoles();

    List<Role> getActiveRoles(Long id);

    List<Role> getAvailableRoles(Long id);
}
