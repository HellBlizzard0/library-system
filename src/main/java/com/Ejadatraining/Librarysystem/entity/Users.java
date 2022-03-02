package com.Ejadatraining.Librarysystem.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author aalsaqqa
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Users implements Serializable {

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", enabled=" + enabled + ", password=" + password + ", username=" + username
                + ", dateOfCreation=" + dateOfCreation + ", lastUpdate=" + lastUpdate + "]";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Users(int id, boolean enabled, String password, String username) {
        super();
        this.id = id;
        this.enabled = enabled;
        this.password = password;
        this.username = username;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "enabled")
    private boolean enabled;

    @NotBlank(message = "New password is mandatory")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "New username is mandatory")
    @Column(name = "username")
    private String username;

    @Column(name = "date_of_creation")
    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfCreation;

    @Column(name = "last_updated")
    @UpdateTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastUpdate;

}
