package com.revature.service;

import java.util.List;

import com.revature.beans.Attempt;

public interface AttemptService {

	public Attempt getAttemptById(int id); 
	
	public List<Attempt> getAllAttempts(); 
	
	public void addAttempt(Attempt attempt); 
	
	public boolean updateAttempt(Attempt attempt); 
	
	public void deleteAttempt(Attempt attempt); 
}
