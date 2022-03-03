package com.Ejadatraining.Librarysystem.dao;

import com.Ejadatraining.Librarysystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Ejadatraining.Librarysystem.entity.Librarian;
import org.springframework.data.jpa.repository.Query;

public interface LibrarianDAO extends JpaRepository<Librarian, Integer> {

    public Librarian findByName(String librarianname);

    @Query(value = "select * from "
            + "Librarian l "
            + "where (l.id is null or l.id = ?1) "
            + "or (l.name is null or l.name = ?2) ", nativeQuery = true)
    public Librarian findLibrarianByIdOrName(Integer id, String librarianname);
}
