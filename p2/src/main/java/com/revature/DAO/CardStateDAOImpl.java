package com.revature.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.beans.Card;
import com.revature.beans.CardState;
import com.revature.util.ConnectionUtil;

public class CardStateDAOImpl implements CardStateDAO {

	// variables
	private SessionFactory sf = ConnectionUtil.getSessionFactory();
	
	//methods
	@Override
	public CardState getCardStateById(int id) {
		CardState cs = null; 
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			cs = s.get(CardState.class,  id); 
			tx.commit();
		}
		return cs; 
	}

	@Override
	public List<CardState> getAllCardStates() {
		List<CardState> cardStates = new ArrayList<>(); 
		//use a Query to retrieve all Cards
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			cardStates = s.createQuery("from CardState").getResultList(); 
			tx.commit();
			s.close();
		}
		return cardStates; 
	}

	@Override
	public boolean updateCardState(CardState cardState) {
		//this is awesome. We use session and the hibernate methods here 
		//and NOT JDBC's connection and other interfaces. 
		try(Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.update(cardState);
			tx.commit(); 
			return true; 
		} catch (Exception e) {
			return false; 
		}
		
	}

	@Override
	public void addCardState(CardState cardState) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.persist(cardState);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void deleteCardState(CardState cardState) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction(); 
			s.delete(cardState); 
			tx.commit(); 
			s.close(); 
		}
	}
}
