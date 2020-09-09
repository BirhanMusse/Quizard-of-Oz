package com.revature.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.User;
import com.revature.beans.UserType;
import com.revature.util.ConnectionUtil;

public class UserTypeDAOImpl implements UserTypeDAO {

	// variables
	private SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	//methods
	@Override
	public UserType getUserTypeById(int id) {
		UserType ut = null; 
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			ut = s.get(UserType.class,  id); 
			tx.commit();
		}
		return ut; 
	}

	@Override
	public List<UserType> getAllUserTypes() {
		List<UserType> userTypes = new ArrayList<>(); 
		//use a Query to retrieve all users
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			userTypes = s.createQuery("from UserType").getResultList(); 
			tx.commit();
			s.close();
		}
		return userTypes; 
	}

	@Override
	public boolean updateUserType(User userType) {
		//this is awesome. We use session and the hibernate methods here 
		//and NOT JDBC's connection and other interfaces. 
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.update(userType);
			tx.commit(); 
			return true; 
		} catch (Exception e) {
			return false; 
		}
		
	}

	@Override
	public void addUserType(UserType userType) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.persist(userType); 
			tx.commit();
			s.close();
		}
	}

	@Override
	public void deleteUserType(UserType userType) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.delete(userType); 
			tx.commit(); 
			s.close(); 
		}
	}

	

}
