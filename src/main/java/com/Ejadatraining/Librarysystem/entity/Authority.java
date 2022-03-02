package com.Ejadatraining.Librarysystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author aalsaqqa
 */
@Entity
@Setter
@Getter
@Table(name = "authorities")
public class Authority {

    @Id
    @Column(name = "username")
    private String username;

    public Authority() {
    }

    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    @Column(name = "authority")
    private String authority;
}
