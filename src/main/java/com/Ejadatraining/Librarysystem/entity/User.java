package com.Ejadatraining.Librarysystem.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.lang.NonNull;

/**
 *
 * @author aalsaqqa
 */
@Entity
@Getter
@Setter
@Table(name = "user")
public class User implements Serializable {

    public User() {
    }

    public User(int id, String name, String username, String password, Date dateOfCreation, Date lastUpdate, UserType type) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.dateOfCreation = dateOfCreation;
        this.lastUpdate = lastUpdate;
        this.type = type;
    }

    @Id
    @GeneratedValue()
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @NonNull
    @NotBlank(message = "New password is mandatory")
    @Column(name = "password")
    private String password;

    
    @Column(name = "date_of_creation")
    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfCreation;

    @Column(name = "last_updated")
    @UpdateTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastUpdate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    public UserType type;

}
