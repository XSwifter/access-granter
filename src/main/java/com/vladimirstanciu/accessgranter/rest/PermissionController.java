package com.vladimirstanciu.accessgranter.rest;

import com.vladimirstanciu.accessgranter.domain.Permission;
import com.vladimirstanciu.accessgranter.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vladimir on 5/21/2017.
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Permission savePermission(@RequestBody Permission permission){
        return permissionService.addPermission(permission);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Permission> getPermissions(){
        return permissionService.getPermissions();
    }

    @RequestMapping(value = "/all-active/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Permission> getActivePermissionsForRole(@PathVariable("id") Long id){
        return permissionService.getActivePermissions(id);
    }

    @RequestMapping(value = "/all-available/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Permission> getAvailablePermissionsForRole(@PathVariable("id") Long id){
        return permissionService.getAvailablePermissions(id);
    }

    @RequestMapping(value = "/all-active-user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Permission> getActivePermissionsForUser(@PathVariable("id") Long id){
        return permissionService.getActivePermissionsForUser(id);
    }
}
