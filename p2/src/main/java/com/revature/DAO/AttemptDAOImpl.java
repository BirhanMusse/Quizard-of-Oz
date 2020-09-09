package com.revature.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Attempt;
import com.revature.util.ConnectionUtil;

public class AttemptDAOImpl implements AttemptDAO {

	// variables
	private SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	//methods
	@Override
	public Attempt getAttemptById(int id) {
		Attempt a = null; 
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			a = s.get(Attempt.class,  id); 
			tx.commit();
		}
		return a; 
	}

	@Override
	public List<Attempt> getAllAttempts() {
		List<Attempt> attempts = new ArrayList<>(); 
		//use a Query to retrieve all Attempts
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			attempts = s.createQuery("from Attempt").getResultList(); 
			tx.commit();
			s.close();
		}
		return attempts; 
	}

	@Override
	public boolean updateAttempt(Attempt attempt) {
		//this is awesome. We use session and the hibernate methods here 
		//and NOT JDBC's connection and other interfaces. 
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.update(attempt);
			tx.commit(); 
			return true; 
		} catch (Exception e) {
			return false; 
		}
		
	}

	@Override
	public void addAttempt(Attempt attempt) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.persist(attempt);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void deleteAttempt(Attempt attempt) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.delete(attempt); 
			tx.commit(); 
			s.close(); 
		}
	}
}
