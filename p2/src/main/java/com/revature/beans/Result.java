package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RESULT")
public class Result {
	
	//constructors 
	public Result() {
	}
	public Result(int id, String resultName) {
		super();
		this.id = id;
		this.resultName = resultName;
	}
	
	//instance variables 
	
	@Id //indicates primary key 
	@Column(name="RESULTID")	
	int id; 
	
	@Column(name="RESULTNAME")
	String resultName; 
		
		
	//getters and setters 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResultName() {
		return resultName;
	}
	public void setResultName(String resultName) {
		this.resultName = resultName;
	}
	
	//toString 
	@Override
	public String toString() {
		return "Result [id=" + id + ", resultName=" + resultName + "]";
	}
	

}
