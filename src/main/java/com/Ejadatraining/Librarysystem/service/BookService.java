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

    public Book getBookByNameOrIdOrAuthorname(Integer id, String name, String authorName) {

        Book book;
        if (id != null) {
            book = this.bookDAO.findById(id).get();
        if (book != null) {
            return book;
            }
        }

        if (name != null) {
        book = this.bookDAO.findByTitle(name);
        if (book != null) {
            return book;
            }
        }

        if (authorName != null) {
        book = this.bookDAO.findByAuthorName(authorName);
        if (book != null) {
            return book;
            }
        }

        return null;
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

    public void updateBook(Book book) {
        this.bookDAO.save(book);
    }

}
