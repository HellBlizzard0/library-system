package com.Ejadatraining.Librarysystem.entity;

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
@Entity@Getter@Setter@Table(name = "users")
public class Person extends User {

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

    @Column(name = "enabled")
    private boolean enabled;

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
	public User(){

	}

	@Id@GeneratedValue()@Column(name = "id")
	private int userId;

}
