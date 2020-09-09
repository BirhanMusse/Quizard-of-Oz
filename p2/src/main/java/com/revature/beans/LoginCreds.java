package com.revature.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
	
	@NamedQuery(
				name = "getLoginCredsIdbyUnameAndPword", 
				query = "select id from LoginCreds where uName = :uNameVar and pWord = :pWordVar")
})

@Entity
@Table(name="LOGINCREDS")
public class LoginCreds {
	
	//instance variables 
	
	@Id //indicates primary key
	//@GeneratedValue(strategy = GenerationType.AUTO, generator = "logInCredsSequence")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "logInCredsSequence")
	@SequenceGenerator(allocationSize=1, name="logInCredsSequence", sequenceName="SQ_LOGINCREDS_PK")
	@Column(name="LOGINCREDSID")
	//@OneToOne(mappedBy = "loginCreds", cascade = CascadeType.ALL)
	private int id;
	
	@Column(name="UNAME")
	private String uName;
	
	@Column(name="PWORD")
	private String pWord; 
	
	//constructors
	public LoginCreds() {
		super();
	}
	public LoginCreds(int id, String uName, String pWord) {
		super();
		this.id = id;
		this.uName = uName;
		this.pWord = pWord;
	}
	public LoginCreds(String uName, String pWord) {
		super();
		this.uName = uName;
		this.pWord = pWord;
	}
	
	//getters and setters 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getpWord() {
		return pWord;
	}
	public void setpWord(String pWord) {
		this.pWord = pWord;
	}
	
	//toString
	@Override
	public String toString() {
		return "LoginCreds [id=" + id + ", uName=" + uName + ", pWord=" + pWord + "]";
	}

}
