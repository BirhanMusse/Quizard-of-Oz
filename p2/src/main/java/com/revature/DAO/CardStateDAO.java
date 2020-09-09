package com.revature.DAO;

import java.util.List;

import com.revature.beans.Card;
import com.revature.beans.CardState;

public interface CardStateDAO {

	public CardState getCardStateById(int id); 
	
	public List<CardState> getAllCardStates(); 
	
	public void addCardState(CardState cardState); 
	
	public boolean updateCardState(CardState cardState); 
	
	public void deleteCardState(CardState cardState); 
}
