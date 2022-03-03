package com.Ejadatraining.Librarysystem.service;

import com.Ejadatraining.Librarysystem.entity.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Ejadatraining.Librarysystem.dao.BookDAO;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author aalsaqqa
 */
@Repository
public class BookService {

    private BookDAO bookDAO;

    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

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
