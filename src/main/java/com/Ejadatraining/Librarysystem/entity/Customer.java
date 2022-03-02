package com.Ejadatraining.Librarysystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author aalsaqqa
 */
@Entity
@Table(name = "customer")
public class Customer extends Users {

    private static final long serialVersionUID = 1L;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public Customer() {
        super();
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", phoneNumber=" + phoneNumber + "]";
    }

    public Customer(String name, String phoneNumber) {
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Customer(int id, String name, String phoneNumber, boolean enabled, String password, String username) {
        super(id, enabled, password, username);
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

}
