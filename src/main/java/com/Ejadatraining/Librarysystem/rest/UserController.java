package com.Ejadatraining.Librarysystem.rest;

import com.Ejadatraining.Librarysystem.entity.Authority;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ejadatraining.Librarysystem.entity.Users;
import com.Ejadatraining.Librarysystem.service.AuthorityService;
import com.Ejadatraining.Librarysystem.service.CustomerService;
import com.Ejadatraining.Librarysystem.service.LibrarianService;
import com.Ejadatraining.Librarysystem.service.UserService;
import java.util.HashMap;

/**
 *
 * @author aalsaqqa
 */
@RestController
@RequestMapping("/api/User")
public class UserController {

    private UserService userService;
    private AuthorityService authorityService;
    private CustomerService customerService;
    private LibrarianService librarianService;

    @Autowired
    public UserController(UserService userService,
            AuthorityService authorityService,
            LibrarianService librarianService,
            CustomerService customerService) {
        this.userService = userService;
        this.authorityService = authorityService;
        this.customerService = customerService;
        this.librarianService = librarianService;
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
    public HashMap<String, Object> login(@RequestParam HashMap<String, String> parm) {
//        Users users = null;
//        System.out.println("com.Ejadatraining.Librarysystem.rest.UserController.login(): " + parm);
    Users u = this.userService.login(parm.get("username"), parm.get("password"));
        if (u == null) {
            return null;
        }
        HashMap<String, Object> res = new HashMap<String, Object>();
        Authority a = this.authorityService.getAuthority(u.getUsername());
        switch (a.getAuthority()) {
            case "ROLE_CUSTOMER":
                res.put("role", "CUSTOMER");
                res.put("data", this.customerService.getCustomerByIdOrName(u.getId(), u.getUsername()));
                break;
            case "ROLE_LIBRARIAN":
                res.put("role", "LIBRARIAN");
                res.put("Librarian", this.librarianService.getLibrarianByIdOrName(u.getId(), null));
                break;
            default:
                throw new AssertionError();
        }
        return res;
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
