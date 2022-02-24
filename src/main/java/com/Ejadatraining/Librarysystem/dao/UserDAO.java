package com.Ejadatraining.Librarysystem.dao;

import com.Ejadatraining.Librarysystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author aalsaqqa
 */
public interface UserDAO extends JpaRepository<User, Integer> {
}
