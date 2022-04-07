package com.Ejadatraining.Librarysystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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

    public Users(int id, boolean enabled, String password, String username, LocalDateTime dateOfCreation, LocalDateTime lastUpdated) {
        this.id = id;
        this.enabled = enabled;
        this.password = password;
        this.username = username;
        this.dateOfCreation = dateOfCreation;
        this.lastUpdated = lastUpdated;
    }

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
                + ", dateOfCreation=" + dateOfCreation + ", lastUpdated=" + lastUpdated + "]";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getTimestampOfCreation() {
        return dateOfCreation;
    }

    public void setTimestampOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdated;
    }

    public void setLastUpdate(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
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

    @Column(name = "date_of_creation", updatable = false)
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime dateOfCreation;

    @Column(name = "last_updated")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime lastUpdated;

    @Column(name = "role")
    private String role;

    public Users(int id, boolean enabled, String password, String username, LocalDateTime dateOfCreation, LocalDateTime lastUpdated, String role) {
        this.id = id;
        this.enabled = enabled;
        this.password = password;
        this.username = username;
        this.dateOfCreation = dateOfCreation;
        this.lastUpdated = lastUpdated;
        this.role = role;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public String getRole() {
        return role;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

}
