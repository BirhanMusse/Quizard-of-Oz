	package com.revature.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CARD")
public class Card {
	
	
	//adding May9th 
	/*
	@ManyToMany(mappedBy = "cards") 
	*/

	
	//constructors
	public Card() {
	}
	public Card(int id, String question, String answer, Topic topic) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.topic = topic;
	}
	public Card(String question, String answer, Topic topic) {
		super();
		this.question = question;
		this.answer = answer;
		this.topic = topic;
	}
	
	//instance variables 
	
	@Id //indicates primary key 
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cardSequence")
	@SequenceGenerator(allocationSize=1, name="cardSequence", sequenceName="SQ_CARD_PK")
	@Column(name="CARDID")
	private int id; 
	
	@Column(name="QUESTION")
	private String question; 
	
	@Column(name="ANSWER")
	private String answer; 
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TOPICID")
	private Topic topic; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "card", fetch=FetchType.EAGER)
	private Set <UserCard> userCards = new HashSet<UserCard>(); 
	
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	//
	public Set<UserCard> getUserCards() {
		return userCards;
	}
	public void setUserCards(Set<UserCard> userCards) {
		this.userCards = userCards;
	}
	
	//methods
	public void addUserCard(UserCard userCard) {
		this.userCards.add(userCard);
	}

	//hashcode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + id;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
		result = prime * result + ((userCards == null) ? 0 : userCards.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (id != other.id)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		if (userCards == null) {
			if (other.userCards != null)
				return false;
		} else if (!userCards.equals(other.userCards))
			return false;
		return true;
	}
	
	//toString
	@Override
	public String toString() {
		return "Card [id=" + id + ", question=" + question + ", answer=" + answer + ", topic="
				+ topic + "]";
	}
	
}
