package com.Ejadatraining.Librarysystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author aalsaqqa
 * @version 1.0
 * @created 28-Feb-2022 3:39:31 PM
 */
@Entity
@Getter
@Setter
@Table(name = "librarian")
public class Librarian extends Users {

    public Librarian() {
        super();
    }

    private static final long serialVersionUID = 1L;

    @Column(name = "name")
    private String name;

    public Librarian(String name) {
        this.name = name;
    }

    public Librarian(int id, boolean enabled, String password, String username) {
        super(id, enabled, password, username);
    }

    public Librarian(int id, boolean enabled, String password, String username, String name) {
        super(id, enabled, password, username);
        this.name = name;
    }
}//end Librarian
