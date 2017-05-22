package com.vladimirstanciu.accessgranter.rest;

import com.vladimirstanciu.accessgranter.domain.Permission;
import com.vladimirstanciu.accessgranter.domain.Role;
import com.vladimirstanciu.accessgranter.service.PermissionService;
import com.vladimirstanciu.accessgranter.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
