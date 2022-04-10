/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ejadatraining.Librarysystem.rest;

import com.Ejadatraining.Librarysystem.entity.Book;
import com.Ejadatraining.Librarysystem.entity.Borrow;
import com.Ejadatraining.Librarysystem.entity.BorrowStatus;
import com.Ejadatraining.Librarysystem.entity.Customer;
import com.Ejadatraining.Librarysystem.service.BookService;
import com.Ejadatraining.Librarysystem.service.BorrowService;
import com.Ejadatraining.Librarysystem.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aalsaqqa
 */
@RestController
@RequestMapping("/api")
public class GenController {

    @Autowired
    BookService bookService;
    @Autowired
    BorrowService borrowService;
    @Autowired
    CustomerService customerService;

    @GetMapping("/genBor")
    public void genBorrow() {
        List<Customer> customerList = customerService.findAll();
        List<Book> bookList = bookService.findAll();

//        for (Customer customer : customerList) {
//            if (customer.getId() == 902) {
//                for (Book book : bookList) {
//                    borrowService.addBorrow(new Borrow(                                0,
//                                customer,
//                                book,
//                                new BorrowStatus(1, "borrowed")));
//
//                }
//            }
//        }
    }
}
