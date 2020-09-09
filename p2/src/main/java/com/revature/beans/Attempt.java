package com.revature.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table(name ="ATTEMPT")
public class Attempt {
	
	//constructors 
	public Attempt() {
	}
	public Attempt(int id, UserCard userCard, Result result) {
		super();
		this.id = id;
		this.userCard = userCard;
		this.result = result;
	}
	public Attempt(UserCard userCard, Result result) {
		super();
		this.userCard = userCard;
		this.result = result;
	}

	//instance variables
	@Id //indicates primary key
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "attemptSequence")
	@SequenceGenerator(allocationSize=1, name="attemptSequence", sequenceName="SQ_ATTEMPT_PK")
	@Column(name="ATTEMPTID")
	int id; 
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "USERCARDID")
	UserCard userCard; 
	
	//additional field
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "RESULTID")
	Result result;

	//getters and setters 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserCard getUserCard() {
		return userCard;
	}
	public void setUserCard(UserCard userCard) {
		this.userCard = userCard;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	
	//toString
	@Override
	public String toString() {
		return "Attempt [id=" + id + ", userCard=" + userCard + ", result=" + result + "]";
	}
}
