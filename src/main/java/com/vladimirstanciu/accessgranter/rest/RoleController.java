package com.vladimirstanciu.accessgranter.rest;

import com.vladimirstanciu.accessgranter.domain.Role;
import com.vladimirstanciu.accessgranter.domain.RolePermission;
import com.vladimirstanciu.accessgranter.domain.User;
import com.vladimirstanciu.accessgranter.domain.UserRole;
import com.vladimirstanciu.accessgranter.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vladimir on 5/21/2017.
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Role saveRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Role getRoleDetails(@PathVariable("id") Long id) {
        return roleService.findById(id);
    }

    @RequestMapping(value = "/add-permission/{id}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public RolePermission addPermission(@RequestBody Long permId, @PathVariable("id") Long roleId) {
        return roleService.addPermission(roleId, permId);
    }

    @RequestMapping(value = "/remove-permission/{id}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void removePermission(@RequestBody Long permId, @PathVariable("id") Long roleId) {
        roleService.removePermission(roleId, permId);
    }

    @RequestMapping(value = "/all-active/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Role> getActiveRolesForUser(@PathVariable("id") Long id) {
        return roleService.getActiveRoles(id);
    }

    @RequestMapping(value = "/all-available/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Role> getAvailableRolesForUser(@PathVariable("id") Long id) {
        return roleService.getAvailableRoles(id);
    }
}
