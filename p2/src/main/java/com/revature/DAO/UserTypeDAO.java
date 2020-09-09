package com.revature.DAO;

import java.util.List;

import com.revature.beans.User;
import com.revature.beans.UserType;

public interface UserTypeDAO {

	public UserType getUserTypeById(int id); 
	
	public List<UserType> getAllUserTypes(); 
	
	public void addUserType(UserType userType); 
	
	public boolean updateUserType(User userType); 
	
	public void deleteUserType(UserType userType); 
}
