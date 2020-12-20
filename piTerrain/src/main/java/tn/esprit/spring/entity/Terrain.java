package tn.esprit.spring.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "terrain")
public class Terrain {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="type")

	private String type;
	@Column(name="etat")

	private String etat;
	@Column(name="prix")

	private float prix;
	@Column(name="endroit")

	private String endroit;
	@Column(name="likes")
	private long likes;
	@ManyToOne
	User user;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Reservation> reservations;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
	public Terrain(String type, String etat, User user, Set<Reservation> reservations) {
		super();
		this.type = type;
		this.etat = etat;
		this.user = user;
		this.reservations = reservations;
	}
	public Terrain() {
		super();
	}
	public Terrain(String type, String etat, float prix, String endroit, User user, Set<Reservation> reservations) {
		super();
		this.type = type;
		this.etat = etat;
		this.prix = prix;
		this.endroit = endroit;
		this.user = user;
		this.reservations = reservations;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getEndroit() {
		return endroit;
	}
	public void setEndroit(String endroit) {
		this.endroit = endroit;
	}
	public long getLikes() {
		return likes;
	}
	public void setLikes(long like) {
		this.likes = like;
	} 
	
	
	
	
	
	

}
