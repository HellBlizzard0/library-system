package com.Ejadatraining.Librarysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Ejadatraining.Librarysystem.entity.Librarian;

@Repository
public interface LibrarianDAO extends JpaRepository<Librarian, Integer> {

    public Librarian findByName(String librarianname);

    @Query(value = "select * from "
            + "Librarian l "
            + "where (l.id is null or l.id = ?1) "
            + "or (l.name is null or l.name = ?2) ", nativeQuery = true)
    public Librarian findLibrarianByIdOrName(Integer id, String librarianname);
}
