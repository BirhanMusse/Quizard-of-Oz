package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TOPIC")
public class Topic {
	

	//constructors
	public Topic() {
	}
	public Topic(int id, String topicName) {
		super();
		this.id = id;
		this.topicName = topicName;
	}
	public Topic(String topicName) {
		super();
		this.topicName = topicName;
	}
	
	//instance variables 
	
	@Id //indicates a primary key
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "topicSequence")
	@SequenceGenerator(allocationSize=1, name="topicSequence", sequenceName="SQ_TOPIC_PK")
	@Column(name="TOPICID")
	int id; 
	
	@Column (name="TOPICNAME")
	String topicName; 
	
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	//hashcode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((topicName == null) ? 0 : topicName.hashCode());
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
		Topic other = (Topic) obj;
		if (id != other.id)
			return false;
		if (topicName == null) {
			if (other.topicName != null)
				return false;
		} else if (!topicName.equals(other.topicName))
			return false;
		return true;
	}
	
	//toString
	@Override
	public String toString() {
		return "Topic [id=" + id + ", topicName=" + topicName + "]";
	}

}
