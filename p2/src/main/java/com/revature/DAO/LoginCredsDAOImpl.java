package com.revature.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.LoginCreds;
import com.revature.util.ConnectionUtil;

public class LoginCredsDAOImpl implements LoginCredsDAO {


	// variables
	private SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	//methods
	@Override
	public LoginCreds getLoginCredsById(int id) {
		LoginCreds lc = null; 
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			lc = s.get(LoginCreds.class,  id); 
			tx.commit();
		}
		return lc; 
	}

	@Override
	public List<LoginCreds> getAllLoginCreds() {
		List<LoginCreds> loginCredss = new ArrayList<>(); 
		//use a Query to retrieve all LoginCredss
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			loginCredss = s.createQuery("from LoginCreds").getResultList(); 
			tx.commit();
			s.close();
		}
		return loginCredss; 
	}

	@Override
	public boolean updateLoginCreds(LoginCreds loginCreds) {
		//this is awesome. We use session and the hibernate methods here 
		//and NOT JDBC's connection and other interfaces. 
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.update(loginCreds);
			tx.commit(); 
			return true; 
		} catch (Exception e) {
			return false; 
		}
		
	}

	@Override
	public void addLoginCreds(LoginCreds loginCreds) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.persist(loginCreds);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void deleteLoginCreds(LoginCreds loginCreds) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.delete(loginCreds); 
			tx.commit(); 
			s.close(); 
		}
	}

}
