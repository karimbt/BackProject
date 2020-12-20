package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.tomcat.jni.Time;

@Entity
@Table(name = "reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
long id;

@ManyToOne

User user;
@ManyToOne
Terrain terrain;

@Temporal (TemporalType.DATE)
Date date;
@Temporal (TemporalType.TIME)
Date time;
@Column(name="etat")

private String etat;
public Reservation(User user, Terrain terrain, Date date, Date time,String etat) {
	super();
	this.user = user;
	this.terrain = terrain;
	this.date = date;
	this.time = time;
	this.etat=etat;
}




public String getEtat() {
	return etat;
}




public void setEtat(String etat) {
	this.etat = etat;
}




public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Terrain getTerrain() {
	return terrain;
}
public void setTerrain(Terrain terrain) {
	this.terrain = terrain;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}
public Reservation() {
	super();
}



}
