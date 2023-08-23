package com.Ejadatraining.Librarysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Ejadatraining.Librarysystem.entity.Users;

/**
 *
 * @author aalsaqqa
 */
@Repository
public interface UserDAO extends JpaRepository<Users, Integer> {

    public Users findByUsername(String username);

    @Query(value = "select * from "
            + "Users u "
            + "where (u.id is null or u.id = ?1) "
            + "or (u.username is null or u.username = ?2) ", nativeQuery = true)
    public Users findByUserByIdOrUsername(Integer id, String username);
}
