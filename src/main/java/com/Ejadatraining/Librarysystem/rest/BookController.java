package com.Ejadatraining.Librarysystem.rest;

import com.Ejadatraining.Librarysystem.entity.Book;
import com.Ejadatraining.Librarysystem.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        List<Book> b = this.bookService.findAll();
        return b;
    }

    @GetMapping("/getBookByNameOrIdOrAuthorname")
    @ResponseBody
    public List<Book> getBookByNameOrIdOrAuthorname(@RequestParam(name = "id", required = false) Integer id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "authorName", required = false) String authorName) {
        return this.bookService.getBookByNameOrIdOrAuthorname(name, id, authorName);
    }

    @PostMapping("/addBook")
    @ResponseBody
    public void addBook(@RequestBody Book book) {
        this.bookService.addBook(book);
    }

    @PostMapping("/addBooks")
    @ResponseBody
    public void addBooks(@RequestBody List<Book> books) {
        this.bookService.addBooks(books);
    }

    @PostMapping("/updateBook")
    @ResponseBody
    public void updateBook(@RequestBody Book book) {
        // System.out.println("com.Ejadatraining.Librarysystem.rest.BookController.updateBook()");
        // Book book = new Book(Integer.parseInt(parm.get("id")), parm.get("title"),
        // parm.get("serialNumber"), parm.get("authorName"), parm.get("description"),
        // Integer.parseInt(parm.get("pageCount")), parm.get("rating"),
        // parm.get("genres"));
        this.bookService.updateBook(book);
    }

    @GetMapping("/deleteBook")
    @ResponseBody
    public void deleteBook(@RequestParam(name = "id") int id) {
        this.bookService.deleteBook(id);
    }
}
