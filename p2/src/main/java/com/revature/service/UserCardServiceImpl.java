package com.revature.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.revature.DAO.CardDAO;
import com.revature.DAO.CardDAOImpl;
import com.revature.DAO.CardStateDAO;
import com.revature.DAO.CardStateDAOImpl;
import com.revature.DAO.UserCardDAO;
import com.revature.DAO.UserCardDAOImpl;
import com.revature.DAO.UserDAO;
import com.revature.DAO.UserDAOImpl;
import com.revature.beans.Card;
import com.revature.beans.CardState;
import com.revature.beans.User;
import com.revature.beans.UserCard;
import com.revature.util.ConnectionUtil;

@Service
public class UserCardServiceImpl implements UserCardService {
	
	// instance variables
	private UserCardDAO ucd = new UserCardDAOImpl();
	private UserDAO ud = new UserDAOImpl();
	private CardDAO cd = new CardDAOImpl(); 
	private CardStateDAO csd = new CardStateDAOImpl(); 

	// service methods
	@Override
	public UserCard getUserCardById(int id) {
		return ucd.getUserCardById(id);
	}

	@Override
	public List<UserCard> getAllUserCards() {
		return ucd.getAllUserCards();
	}

	@Override
	public void addUserCard(UserCard userCard) {
		
		//public UserCard(int id, User user, Card card, CardState cardState)
		//DAOs 
		User user = ud.getUserById(userCard.getUser().getId()); 
		Card card = cd.getCardById(16);
		CardState learning = csd.getCardStateById(1); 
		 
		SessionFactory sf = ConnectionUtil.getSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		//userCard2 brings userCard object into session context to persist to DB
		UserCard userCard2 = new UserCard();
		
		userCard2.setCard(userCard.getCard());
		userCard2.setUser(userCard.getUser());
		userCard2.setCardState(userCard.getCardState());
		
		s.save(userCard2);
		
		System.out.println(s.getStatistics());
		tx.commit();
		s.close();
		//ucd.addUserCard(userCard);
	}

	@Override
	public boolean updateUserCard(UserCard userCard) {
		return ucd.updateUserCard(userCard);
	}

	@Override
	public void deleteUserCard(UserCard userCard) {
		ucd.deleteUserCard(userCard);
	}
}
