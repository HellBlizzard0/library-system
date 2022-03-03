package com.Ejadatraining.Librarysystem.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author aalsaqqa
 */
@Entity
@Getter
@Setter
@Table(name = "borrow")
public class Borrow implements Serializable {

    public Borrow() {
    }

    public Borrow(int id, Customer customer, Book book, BorrowStatus status, Timestamp dateOfCreation, Timestamp lastUpdate) {
        super();
        this.id = id;
        this.customer = customer;
        this.book = book;
        this.status = status;
        this.dateOfCreation = dateOfCreation;
        this.lastUpdate = lastUpdate;
    }

    @Id
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private BorrowStatus status;

    @Column(name = "date_of_creation", updatable = false)
    @CreationTimestamp
    private Timestamp dateOfCreation;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Timestamp lastUpdate;
}
