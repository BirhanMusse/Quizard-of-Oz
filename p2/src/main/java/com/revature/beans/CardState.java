package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="CARDSTATE")
public class CardState {

	// constructors
	public CardState() {
	}
	public CardState(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// instance variables
	@Id //indicates primary key 
	@Column(name="CARDSTATEID")
	int id;
	
	@Column(name="CARDSTATENAME")
	String name;

	// getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	// toString
	@Override
	public String toString() {
		return "CardState [id=" + id + ", name=" + name + "]";
	}
}
