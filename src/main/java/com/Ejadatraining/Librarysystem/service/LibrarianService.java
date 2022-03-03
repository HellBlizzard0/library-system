package com.Ejadatraining.Librarysystem.service;

import com.Ejadatraining.Librarysystem.dao.AuthorityDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Ejadatraining.Librarysystem.dao.LibrarianDAO;
import com.Ejadatraining.Librarysystem.entity.Authority;
import com.Ejadatraining.Librarysystem.entity.Librarian;

@Repository
public class LibrarianService {

    private LibrarianDAO librarianDAO;
    private AuthorityDAO authorityDAO;

    @Autowired
    public LibrarianService(LibrarianDAO librarianDAO, AuthorityDAO authorityDAO) {
        this.librarianDAO = librarianDAO;
        this.authorityDAO = authorityDAO;
    }

    public List<Librarian> findAll() {
        return this.librarianDAO.findAll();
    }

    public Librarian getLibrarianByIdOrName(Integer id, String librarianname) {
        return this.librarianDAO.findLibrarianByIdOrName(id, librarianname);
    }

    @Transactional
    public void createLibrarian(Librarian librarian) {
        this.librarianDAO.save(librarian);
        Authority a = new Authority(librarian.getUsername(), "ROLE_LIBRARIAN");
        this.authorityDAO.save(a);
    }

    @Transactional
    public void deleteLibrarian(int id) {
        this.librarianDAO.deleteById(id);
    }

    @Transactional
    public void updateLibrarian(Librarian librarian) {
        // Get Librarian pre-update.
        Librarian l = this.librarianDAO.findById(librarian.getId()).get();
        // Get Authority pre-update.
        Authority a = new Authority(l.getUsername(), "ROLE_LIBRARIAN");

        // Update Librarian/User entry, hopefully.
        this.librarianDAO.save(librarian);

        // Remove previous Authority entry.
        this.authorityDAO.delete(this.authorityDAO.getById(librarian.getUsername()));
        // Save new authority entry.
        this.authorityDAO.save(a);
    }
}
