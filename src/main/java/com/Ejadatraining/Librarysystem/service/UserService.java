package com.Ejadatraining.Librarysystem.service;

import com.Ejadatraining.Librarysystem.dao.UserDAO;
import com.Ejadatraining.Librarysystem.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author aalsaqqa
 */
public class UserService {
    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> findAll() {
        return this.userDAO.findAll();
    }
}
