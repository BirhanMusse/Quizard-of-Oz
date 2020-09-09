package com.revature.service;

import java.util.List;

import com.revature.beans.Card;

public interface CardService {

	public Card getCardById(int id); 
	
	public List<Card> getAllCards(); 
	
	public void addCard(Card card); 
	
	public boolean updateCard(Card card); 
	
	public void deleteCard(Card card); 
}
