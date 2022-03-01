package com.Ejadatraining.Librarysystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ejadatraining.Librarysystem.entity.Librarian;

public interface LibrarianDAO extends JpaRepository<Librarian, Integer> {

	// Librarian findByName(String librarianname);

}
