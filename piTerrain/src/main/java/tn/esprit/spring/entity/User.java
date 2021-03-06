package tn.esprit.spring.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 10)
	@Column(name="nom")
	private String nom;
	@Size(max = 10)
	@Column(name="prenom")
	private String prenom;
	@Size(max = 20)
	private String username;

	
	@Size(max = 50)
	@Email
	private String email;

	
	@Size(max = 120)
	private String password;

	@ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
    @NotNull
	private Set<Role> roles ;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Terrain> terrains; 
	
	

	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Reservation> reservation; 
	

	public Set<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(Set<Reservation> reservation) {
		this.reservation = reservation;
	}

	public Set<Terrain> getTerrains() {
		return terrains;
	}



	public void setTerrains(Set<Terrain> terrains) {
		this.terrains = terrains;
	}



	public User() {
	}

	

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
public User( String nom, String prenom,	String username,  String email, String password) {
	
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public User( String nom, String prenom,	String username,  String email, String password,Set<Role> roles) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles=roles;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	

}
