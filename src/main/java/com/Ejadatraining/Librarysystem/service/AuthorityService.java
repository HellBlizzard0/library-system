/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ejadatraining.Librarysystem.service;

import com.Ejadatraining.Librarysystem.dao.AuthorityDAO;
import com.Ejadatraining.Librarysystem.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aalsaqqa
 */
@Repository
public class AuthorityService {
    private AuthorityDAO authorityDAO;

    @Autowired
    public AuthorityService(AuthorityDAO authorityDAO) {
        this.authorityDAO = authorityDAO;
    }

    public Authority getAuthority(String username) {
        return this.authorityDAO.findByUsername(username);
    }
}
