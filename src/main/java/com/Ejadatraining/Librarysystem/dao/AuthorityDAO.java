/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ejadatraining.Librarysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ejadatraining.Librarysystem.entity.Authority;

/**
 *
 * @author aalsaqqa
 */
@Repository
public interface AuthorityDAO extends JpaRepository<Authority, String> {

}
