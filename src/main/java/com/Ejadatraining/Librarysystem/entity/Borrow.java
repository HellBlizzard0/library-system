package com.Ejadatraining.Librarysystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author aalsaqqa
 */
@Entity
@Table(name = "borrow")
public class Borrow implements Serializable {

    public static Borrow newRequets(HashMap<String, String> p) {
        Borrow b = new Borrow(0, new Customer(Integer.parseInt(p.get("customerId"))), new Book(Integer.parseInt(p.get("bookId"))), new BorrowStatus(BorrowStatus.REQUESTED, "REQUESTED"));
        return b;
    }

    public Borrow() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(Customer user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setStatus(BorrowStatus status) {
        this.status = status;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setLastUpdated(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getId() {
        return id;
    }

    public Customer getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public BorrowStatus getStatus() {
        return status;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public LocalDate getLastUpdated() {
        return lastUpdate;
    }

    public Borrow(int id, Customer customer, Book book, BorrowStatus status, LocalDate dateOfCreation,
            LocalDate lastUpdate) {
        super();
        this.id = id;
        this.user = customer;
        this.book = book;
        this.status = status;
        this.dateOfCreation = dateOfCreation;
        this.lastUpdate = lastUpdate;
    }

    @Id
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer user;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private BorrowStatus status;

    @Column(name = "date_of_creation", updatable = false)
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfCreation;

    @Column(name = "last_updated")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate lastUpdate;

    public Borrow(int id, Customer customer, Book book, BorrowStatus status) {
        this.id = id;
        this.user = customer;
        this.book = book;
        this.status = status;
    }

}
