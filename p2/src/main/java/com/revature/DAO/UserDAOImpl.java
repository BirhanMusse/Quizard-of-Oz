package com.revature.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	// variables
	private SessionFactory sf = ConnectionUtil.getSessionFactory();

	// methods
	@Override
	public User getUserById(int id) {
		User u = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			u = s.get(User.class, id);
			tx.commit();
		}
		return u;
	}

	public User getUserbyUnameAndPword(String uName, String pWord) {
		//initialize variables 
		Integer loginCredsId = 0; 
		User u = null;
		//
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			// query 1
			Query q1 = s.getNamedQuery("getLoginCredsIdbyUnameAndPword");
			q1.setParameter("uNameVar", uName);
			q1.setParameter("pWordVar", pWord);
			//
			List<Integer> loginCredsIdList = q1.getResultList();
			//
			for (Integer id : loginCredsIdList) {
				loginCredsId = id;
			}
			// query 2
			Query q2 = s.getNamedQuery("getUserbyLoginCredsId");
			q2.setParameter("loginCredsVar", loginCredsId);
			//
			List<User> userList = q2.getResultList();
			//
			for (User user : userList) {
				u = user; 
			}
			tx.commit();
		}
		return u; 
	}
	
	@Override
	public List<Integer> getAllAdminIds() {
		//initialize list 
		List<Integer> adminIdList; 
		//
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			// query
			Query q = s.getNamedQuery("getAllAdminIds"); 
			//
			adminIdList = q.getResultList();
		}
		return adminIdList; 
	}
	
	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		// use a Query to retrieve all users
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			users = s.createQuery("from User").getResultList();
			tx.commit();
			s.close();
		}
		return users;
	}

	@Override
	public boolean updateUser(User user) {
		// this is awesome. We use session and the hibernate methods here
		// and NOT JDBC's connection and other interfaces.
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(user);
			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public void addUser(User user) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(user);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void deleteUser(User user) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(user);
			tx.commit();
			s.close();
		}
	}



}
