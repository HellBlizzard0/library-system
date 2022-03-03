package com.Ejadatraining.Librarysystem.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Getter
@Setter
@Entity
@Table(name = "book")
public class Book implements Serializable {

    public Book() {
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "date_of_creation", updatable = false)
    @CreationTimestamp
    private Timestamp dateOfCreation;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Timestamp lastUpdate;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "author_name")
    private String authorName;

}
