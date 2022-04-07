/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ejadatraining.Librarysystem.dao;

import com.Ejadatraining.Librarysystem.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author aalsaqqa
 */
public interface AuthorityDAO extends JpaRepository<Authority, String> {

    @Query(value = "select * from "
            + "Authority a "
            + "where (a.id = ?1)", nativeQuery = true)
    public Authority findByUsername(String username);
}
