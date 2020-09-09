package com.revature.beans;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // indicates that the class represents a DB entity
@Table(name ="USRCARD")
public class UserCard {
	
	//constructors
	public UserCard() {
	}
	public UserCard(int id, User user, Card card, CardState cardState) {
		super();
		this.user = user;
		this.card = card;
		this.cardState = cardState;
	}
	public UserCard(User user, Card card, CardState cardState) {
		super();
		this.user = user;
		this.card = card;
		this.cardState = cardState;
	}
	//instance variables
	
	@Id //indicates primary key 
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "userCardSequence")
	@SequenceGenerator(allocationSize=1, name="userCardSequence", sequenceName="SQ_USRCARD_PK")
	@Column(name="USRCARDID")
	int id; 
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USRID")  
	//@Column(name="USRID")
	User user; 
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CARDID")
	//@Column(name="CARDID")
	Card card; 
	
	//additional field
	@ManyToOne(fetch=FetchType.EAGER) 
	@JoinColumn(name="CARDSTATEID")
	CardState cardState;
	
	//getters and setters
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public CardState getCardState() {
		return cardState;
	}
	public void setCardState(CardState cardState) {
		this.cardState = cardState;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//toString
	@Override
	public String toString() {
		return "UserCard [id=" + id + ", user=" + user + ", card=" + card + ", cardState=" + cardState + "]";
	}

}