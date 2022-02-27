package com.Ejadatraining.Librarysystem.controller;

import com.Ejadatraining.Librarysystem.entity.Book;
import com.Ejadatraining.Librarysystem.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aalsaqqa
 */
@RestController
@RequestMapping("/api/Book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @RequestMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return null;
    }
    @RequestMapping("/getBookByNameOrIdOrAuthorname")
    @ResponseBody
    public Book getBookByNameOrIdOrAuthorname(@RequestParam(name = "id") Long id, @RequestParam(name = "name") String name, @RequestParam(name = "authorName") String authorName) {
        return null;
    }
    @PostMapping("/addBook")
    @ResponseBody
    public Book addBook(@RequestParam(name = "book") Book book) {
        return null;
    }
    @PostMapping("/addBooks")
    @ResponseBody
    public void addBooks(@RequestParam(name = "books") List<Book> books) {
        return;
    }
    @RequestMapping("/updateBook")
    @ResponseBody
    public void updateBook(@RequestParam(name = "id") Long id) {
        return;
    }
    @RequestMapping("/deleteBook")
    @ResponseBody
    public void deleteBook(@RequestParam(name = "id") Long id) {
        return;
    }
}
