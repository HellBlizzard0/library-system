package com.Ejadatraining.Librarysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Ejadatraining.Librarysystem.dao.UserDAO;
import com.Ejadatraining.Librarysystem.entity.Users;

/**
 *
 * @author aalsaqqa
 */
@Service
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
}
