package com.vladimirstanciu.accessgranter.rest;

import com.vladimirstanciu.accessgranter.domain.User;
import com.vladimirstanciu.accessgranter.domain.UserRole;
import com.vladimirstanciu.accessgranter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vladimir on 5/21/2017.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public User saveUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserDetails(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @RequestMapping(value = "/add-role/{id}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public UserRole addRole(@RequestBody Long roleId, @PathVariable("id") Long userId){
        return userService.addRole(userId, roleId);
    }

    @RequestMapping(value = "/remove-role/{id}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeRole(@RequestBody Long roleId, @PathVariable("id") Long userId){
        userService.removeRole(userId, roleId);
    }
}
