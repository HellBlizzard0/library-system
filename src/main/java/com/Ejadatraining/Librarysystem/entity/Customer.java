package com.Ejadatraining.Librarysystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author aalsaqqa
 */
@Entity
@Getter
@Setter
@Table(name = "customer")
public class Customer extends Users {

	private static final long serialVersionUID = 1L;


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

	public Customer(String name, String phoneNumber, boolean enabled, String password, String username) {
		super(0, enabled, password, username);
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "name")
    private String name;



	@Column(name = "phone_number")
	private String phoneNumber;

}
