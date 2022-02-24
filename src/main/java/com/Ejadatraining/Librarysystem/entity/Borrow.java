package com.Ejadatraining.Librarysystem.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "user-borrow-publication")
public class Borrow implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    public Borrow(int id, User user, Book book, Date dateOfCreation, Date lastUpdate) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.dateOfCreation = dateOfCreation;
        this.lastUpdate = lastUpdate;
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @Column(name = "dateOfCreation")
    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfCreation;

    @Column(name = "lastUpdated")
    @UpdateTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastUpdate;
}
