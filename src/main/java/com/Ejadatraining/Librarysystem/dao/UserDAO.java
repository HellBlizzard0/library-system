package com.Ejadatraining.Librarysystem.dao;

import com.Ejadatraining.Librarysystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author aalsaqqa
 */
public interface UserDAO extends JpaRepository<Users, Integer> {

    public Users findByUsername(String username);
}
