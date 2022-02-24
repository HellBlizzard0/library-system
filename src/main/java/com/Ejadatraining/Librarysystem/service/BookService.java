package com.Ejadatraining.Librarysystem.service;

import com.Ejadatraining.Librarysystem.entity.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Ejadatraining.Librarysystem.dao.BookDAO;

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
}
