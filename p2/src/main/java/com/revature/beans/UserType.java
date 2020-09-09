package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USRTYPE")
public class UserType {

	//instance variables
	@Id //indicates primary key
	@Column(name="USRTYPEID")
	private int id; 
	
	@Column(name="USRTYPENAME")
	private String userTypeName;
	
	//constructors
	public UserType() {
	}
	public UserType(int id, String userTypeName) {
		super();
		this.id = id;
		this.userTypeName = userTypeName;
	}
	public UserType(String userTypeName) {
		super();
		this.userTypeName = userTypeName;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	
	//toString
	@Override
	public String toString() {
		return "UserType [id=" + id + ", userTypeName=" + userTypeName + "]";
	}

}
