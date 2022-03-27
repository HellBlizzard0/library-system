package com.Ejadatraining.Librarysystem.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ejadatraining.Librarysystem.entity.Users;
import com.Ejadatraining.Librarysystem.service.UserService;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author aalsaqqa
 */
@RestController
@RequestMapping("/api/User")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/getAllUsers")
    public List<Users> getAllUsers() {
        return this.userService.findAll();
    }
    @PostMapping("/getUserByIdOrUsername")
    @ResponseBody
    public Users getUserByIdOrUsername(@RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "username", required = false) String username) {
        return this.userService.getUserByIdOrUsername(id, username);
    }
    @PostMapping("/createUser")
    @ResponseBody
    public void createUser(@RequestParam(name = "user") Users user) {
		System.err.println(user);
        this.userService.createUser(user);
    }

    @PostMapping("/login")
    @ResponseBody
    public Users login(@RequestParam HashMap<String, String> parm) {
//        Users users = null;
//        System.out.println("com.Ejadatraining.Librarysystem.rest.UserController.login(): " + parm);
        return this.userService.login(parm.get("username"), parm.get("password"));
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public void updateUser(@RequestParam(name = "user") Users user) {
        this.userService.updateUser(user);
    }
    @RequestMapping("/deleteUser")
    @ResponseBody
    public void deleteUser(@RequestParam(name = "id") int id) {
        this.userService.deleteUser(id);
    }
}
