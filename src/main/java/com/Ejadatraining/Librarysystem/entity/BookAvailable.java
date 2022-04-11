/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ejadatraining.Librarysystem.entity;

/**
 *
 * @author aalsaqqa
 */
public class BookAvailable {
    private Book book;
    private boolean available;

    public void setBook(Book book) {
        this.book = book;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Book getBook() {
        return book;
    }

    public boolean isAvailable() {
        return available;
    }

    public BookAvailable() {
    }

    public BookAvailable(Book book, boolean available) {
        this.book = book;
        this.available = available;
    }
}
