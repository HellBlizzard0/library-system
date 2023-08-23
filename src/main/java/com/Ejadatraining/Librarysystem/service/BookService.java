package com.Ejadatraining.Librarysystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Ejadatraining.Librarysystem.dao.BookDAO;
import com.Ejadatraining.Librarysystem.entity.Book;

/**
 *
 * @author aalsaqqa
 */
@Service
public class BookService {

    @Autowired
    private BookDAO bookDAO;

    public List<Book> findAll() {
        return this.bookDAO.findAll();
    }

    public List<Book> getBookByNameOrIdOrAuthorname(String name, Integer id, String authorName) {
        List<Book> b = this.bookDAO.getBookByNameOrIdOrAuthorname(name, id, authorName);
        return b;
    }

    @Transactional
    public void addBook(Book book) {
        this.bookDAO.save(book);
    }

    @Transactional
    public void addBooks(List<Book> books) {
        this.bookDAO.saveAll(books);
    }

    @Transactional
    public void deleteBook(int id) {
        this.bookDAO.deleteById(id);
    }

    @Transactional
    public void updateBook(Book book) {
        this.bookDAO.save(book);
    }

}
