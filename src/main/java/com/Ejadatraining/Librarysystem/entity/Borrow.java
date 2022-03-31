package com.Ejadatraining.Librarysystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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

    public Borrow(int id, Customer customer, Book book, BorrowStatus status, LocalDateTime dateOfCreation, LocalDateTime lastUpdate) {
        super();
        this.id = id;
        this.customer = customer;
        this.book = book;
        this.status = status;
        this.dateOfCreation = dateOfCreation;
        this.lastUpdated = lastUpdate;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime dateOfCreation;

    @Column(name = "last_updated")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime lastUpdated;
}
