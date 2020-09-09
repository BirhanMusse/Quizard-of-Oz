package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.DAO.AttemptDAO;
import com.revature.DAO.AttemptDAOImpl;
import com.revature.beans.Attempt;

@Service 
public class AttemptServiceImpl implements AttemptService {

	// instance variables
	private AttemptDAO ad = new AttemptDAOImpl();

	// service methods
	@Override
	public Attempt getAttemptById(int id) {
		return ad.getAttemptById(id);
	}

	@Override
	public List<Attempt> getAllAttempts() {
		return ad.getAllAttempts();
	}

	@Override
	public void addAttempt(Attempt attempt) {
		ad.addAttempt(attempt);
	}

	@Override
	public boolean updateAttempt(Attempt attempt) {
		return ad.updateAttempt(attempt);
	}

	@Override
	public void deleteAttempt(Attempt attempt) {
		ad.deleteAttempt(attempt);
	}

}
