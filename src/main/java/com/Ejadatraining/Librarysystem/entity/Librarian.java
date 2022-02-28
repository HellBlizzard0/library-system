package com.Ejadatraining.Librarysystem.entity;

import java.util.Date;
import javax.persistence.Table;

/**
 * @author aalsaqqa
 * @version 1.0
 * @created 28-Feb-2022 3:39:31 PM
 */
@Entity
@Getter
@Setter
@Table(name = "users")
public class Librarian extends User {

	private Date dateOfCreation;
	private Date lastUpdate;
	private String name;
	private int userId;

	public Librarian(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}//end Librarian