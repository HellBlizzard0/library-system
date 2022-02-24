package com.Ejadatraining.Librarysystem.controller;

import com.Ejadatraining.Librarysystem.dao.UserDAO;
import com.Ejadatraining.Librarysystem.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author aalsaqqa
 */
@Controller
public class UserController {

    private UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers() {
        return null;
    }

    public User getUserByIdOrUsername(Long id, String username) {
        return null;
    }

    public void createUser(User user) {
    }

    public void updateUser(Long id) {
    }

    public void deleteUser(Long id) {
    }
}
