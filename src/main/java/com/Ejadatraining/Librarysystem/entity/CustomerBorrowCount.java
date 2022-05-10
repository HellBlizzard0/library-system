/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Ejadatraining.Librarysystem.entity;

/**
 *
 * @author aalsaqqa
 */
public class CustomerBorrowCount {
    private Customer customer;
    private int borrowCount;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setBorrowCount(int borrowCount) {
        this.borrowCount = borrowCount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public CustomerBorrowCount(Customer customer, int borrowCount) {
        this.customer = customer;
        this.borrowCount = borrowCount;
    }
}
