package com.vladimirstanciu.accessgranter.rest;

import com.vladimirstanciu.accessgranter.domain.Role;
import com.vladimirstanciu.accessgranter.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Role saveRole(@RequestBody Role role){
        return roleService.addRole(role);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Role> getRoles(){
        return roleService.getRoles();
    }

    @RequestMapping(value = "/all-active/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Role> getActiveRolesForUser(@PathVariable("id") Long id){
        return roleService.getActiveRoles(id);
    }

    @RequestMapping(value = "/all-available/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Role> getAvailableRolesForUser(@PathVariable("id") Long id){
        return roleService.getAvailableRoles(id);
    }
}
