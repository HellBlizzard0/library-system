package com.Ejadatraining.Librarysystem.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Getter
@Setter
@Entity
@Table(name = "publication")
public class Book implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "dateOfCreation")
    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfCreation;

    @Column(name = "lastUpdated")
    @UpdateTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastUpdate;

    @Column(name = "serial_number")
    private String serialNumber;

    public Book(int id, String title, Date dateOfCreation, Date lastUpdate, String serialNumber) {
        this.id = id;
        this.title = title;
        this.dateOfCreation = dateOfCreation;
        this.lastUpdate = lastUpdate;
        this.serialNumber = serialNumber;
    }

}
