package com.Ejadatraining.Librarysystem.dao;

import com.Ejadatraining.Librarysystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author aalsaqqa
 */
public interface UserDAO extends JpaRepository<Users, Integer> {

    public Users findByUsername(String username);

    @Query(value = "select * from "
            + "Users u "
            + "where (u.id is null or u.id = ?1) "
            + "or (u.username is null or u.username = ?2) ", nativeQuery = true)
    public Users findByUserByIdOrUsername(Integer id, String username);

    @Query(value = "select * from "
            + "Users u "
            + "where  u.username = ?1 "
            + "and u.password = ?2", nativeQuery = true)
    public Users login(String username, String password);
}
