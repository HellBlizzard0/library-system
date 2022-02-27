package com.Ejadatraining.Librarysystem.controller;

import com.Ejadatraining.Librarysystem.entity.User;
import com.Ejadatraining.Librarysystem.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public List<User> getAllUsers() {
        return null;
    }
    @PostMapping("/getUserByIdOrUsername")
    @ResponseBody
    public User getUserByIdOrUsername(@RequestParam(name = "id") Long id, @RequestParam(name = "username") String username) {
        return null;
    }
    @PostMapping("/createUser")
    @ResponseBody
    public void createUser(@RequestParam(name = "user") User user) {
    }
    @RequestMapping("/updateUser")
    @ResponseBody
    public void updateUser(@RequestParam(name = "id") Long id) {
    }
    @RequestMapping("/deleteUser")
    @ResponseBody
    public void deleteUser(@RequestParam(name = "id") Long id) {
    }
}
