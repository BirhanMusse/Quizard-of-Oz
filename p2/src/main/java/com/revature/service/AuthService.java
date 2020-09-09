package com.revature.service;

import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.model.Credentials;
import com.revature.model.UserLogging;



@Service
public class AuthService {
	
public UserLogging isValidUser(Credentials creds) {
		

		// instance variables, initializations // user to be returned if authenticated 
		UserService us = new UserServiceImpl(); 
		UserLogging ul = null;  
		
		//set of credentials from login
		String username = creds.getUsername(); 
		String password = creds.getPassword(); 
	
		//
		System.out.println(username);
		System.out.println(password);
		
		//user if exists in DB generate user object 
		User user = us.getUserByUnameAndPWord(username, password); 
		//
		System.out.println("Generated user: " + user);
	
		//if valid credentials create UserLogging object from User object 
		if (user != null) {
			
			ul = new UserLogging(user.getId(), user.getLoginCreds().getuName(), user.getFirstName(), user.getLastName(), user.getEmail()); 
		}
		
		return ul; 
	}
}
