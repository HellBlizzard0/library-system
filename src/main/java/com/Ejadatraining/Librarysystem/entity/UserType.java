package com.Ejadatraining.Librarysystem.entity;

import java.io.Serializable;
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
@Getter
@Setter
@Table(name = "usertype")
public class UserType implements Serializable {

    public UserType() {
    }

    public UserType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;
}

/**
 * @author aalsaqqa
 * @version 1.0
 * @updated 28-Feb-2022 3:39:01 PM
 */
@Entity@Getter@Setter@Table(name = "usertype")
public class Authorities implements Serializable {

	@Column(name = "type")
	private String role;
	@Id@Column(name = "id")
	private String username;



	public void finalize() throws Throwable {

	}
	public Authorities(){

	}

	/**
	 * 
	 * @param username
	 * @param role
	 */
	public Authorities(String username, String role){

	}
}//end Authorities
