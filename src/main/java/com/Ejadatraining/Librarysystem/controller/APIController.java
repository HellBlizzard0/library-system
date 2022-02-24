package com.Ejadatraining.Librarysystem.controller;

import com.Ejadatraining.Librarysystem.entity.Book;
import com.Ejadatraining.Librarysystem.service.BookService;
import org.jeasy.random.EasyRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Main API Controller to test the JPA repositories.
 *
 * @author aalsaqqa
 */
@Controller
@RequestMapping(value = "/api")
public class APIController {

    private final BookService bookService;

    @Autowired
    public APIController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/log-publication")
    public String logPublication(Model model) {
        EasyRandom generator = new EasyRandom();
        Book book = generator.nextObject(Book.class);
        model.addAttribute("book", book);
        return "log-publication";
    }
}
