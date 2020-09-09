package com.revature.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Result;
import com.revature.util.ConnectionUtil;

public class ResultDAOImpl implements ResultDAO {


	// variables
	private SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	//methods
	@Override
	public Result getResultById(int id) {
		Result r = null; 
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			r = s.get(Result.class,  id); 
			tx.commit();
		}
		return r; 
	}

	@Override
	public List<Result> getAllResults() {
		List<Result> results = new ArrayList<>(); 
		//use a Query to retrieve all Results
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			results = s.createQuery("from Result").getResultList(); 
			tx.commit();
			s.close();
		}
		return results; 
	}

	@Override
	public boolean updateResult(Result result) {
		//this is awesome. We use session and the hibernate methods here 
		//and NOT JDBC's connection and other interfaces. 
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.update(result);
			tx.commit(); 
			return true; 
		} catch (Exception e) {
			return false; 
		}
		
	}

	@Override
	public void addResult(Result result) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.persist(result);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void deleteResult(Result result) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.delete(result); 
			tx.commit(); 
			s.close(); 
		}
	}
	
}
