package com.Ejadatraining.Librarysystem.service;

import com.Ejadatraining.Librarysystem.dao.UserDAO;
import com.Ejadatraining.Librarysystem.entity.Users;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author aalsaqqa
 */
@Repository
public class UserService {
    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<Users> findAll() {
        return this.userDAO.findAll();
    }

    public Users getUserByIdOrUsername(Integer id, String username) {
        return this.userDAO.findByUserByIdOrUsername(id, username);
    }

    @Transactional
    public void createUser(Users user) {
        this.userDAO.save(user);
    }

    @Transactional
    public void deleteUser(int id) {
        this.userDAO.deleteById(id);
    }

    @Transactional
    public void updateUser(Users user) {
        this.userDAO.save(user);
    }

    public Users login(String username, String password) {
        return this.userDAO.login(username, password);
    }
}
