/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ejadatraining.Librarysystem.entity;

import java.util.List;

/**
 *
 * @author aalsaqqa
 */
public class BookList {
    private List<Book> BookList;

    public BookList() {
    }

    public void setBookList(List<Book> BookList) {
        this.BookList = BookList;
    }

    public List<Book> getBookList() {
        return BookList;
    }

    public BookList(List<Book> BookList) {
        this.BookList = BookList;
    }
}
