package com.Ejadatraining.Librarysystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(referencedColumnName = "id")
	// private User user;

}//end Librarian