package com.Ejadatraining.Librarysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Ejadatraining.Librarysystem.dao.LibrarianDAO;
import com.Ejadatraining.Librarysystem.entity.Librarian;

@Repository
public class LibrarianService {
	private LibrarianDAO librarianDAO;

	@Autowired
	public LibrarianService(LibrarianDAO librarianDAO) {
		this.librarianDAO = librarianDAO;
    }

	public List<Librarian> findAll() {
		return this.librarianDAO.findAll();
	}

	public Librarian getLibrarianByIdOrName(Integer id, String librarianname) {
		Librarian librarian = null;
		if (id != null) {
			librarian = this.librarianDAO.findById(id).get();
			if (librarian != null) {
				return librarian;
			}
		}
		if (librarianname != null) {
			// librarian = this.librarianDAO.findByName(librarianname);
			if (librarian != null) {
				return librarian;
			}
		}
		return null;
	}

	@Transactional
	public void createLibrarian(Librarian librarian) {
		this.librarianDAO.save(librarian);
	}

	@Transactional
	public void deleteLibrarian(int id) {
		this.librarianDAO.deleteById(id);
	}

	@Transactional
	public void updateLibrarian(Librarian librarian) {
		this.librarianDAO.save(librarian);
	}
}
