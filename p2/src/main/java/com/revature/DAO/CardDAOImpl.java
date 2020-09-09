package com.revature.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Card;
import com.revature.util.ConnectionUtil;

public class CardDAOImpl implements CardDAO{

	// variables
	private SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	//methods
	@Override
	public Card getCardById(int id) {
		Card c = null; 
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			c = s.get(Card.class,  id); 
			tx.commit();
		}
		return c; 
	}

	@Override
	public List<Card> getAllCards() {
		List<Card> cards = new ArrayList<>(); 
		//use a Query to retrieve all Cards
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			cards = s.createQuery("from Card").getResultList(); 
			tx.commit();
			s.close();
		}
		return cards; 
	}

	@Override
	public boolean updateCard(Card card) {
		//this is awesome. We use session and the hibernate methods here 
		//and NOT JDBC's connection and other interfaces. 
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.update(card);
			tx.commit(); 
			return true; 
		} catch (Exception e) {
			return false; 
		}
		
	}

	@Override
	public void addCard(Card card) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.persist(card);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void deleteCard(Card card) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.delete(card); 
			tx.commit(); 
			s.close(); 
		}
	}
}
