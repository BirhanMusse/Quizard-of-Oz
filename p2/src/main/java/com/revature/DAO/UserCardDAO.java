package com.revature.DAO;

import java.util.List;

import com.revature.beans.UserCard;

public interface UserCardDAO {

	public UserCard getUserCardById(int id); 
	
	public List<UserCard> getAllUserCards(); 
	
	public void addUserCard(UserCard userCard); 
	
	public boolean updateUserCard(UserCard userCard); 
	
	public void deleteUserCard(UserCard userCard); 
	
	public List<UserCard> getAllCardsByUserId(int id);

}
