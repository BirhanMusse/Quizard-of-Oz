package com.revature.service;

import java.util.List;

import com.revature.beans.User;

public interface UserService {

	//crud 
	public User getUserById(int id); 
	
	public List<User> getAllUsers(); 
	
	public void addUser(User user); 
	
	public boolean updateUser(User user); 
	
	public void deleteUser(User user); 
	
	//extras 
	public User getUserByUnameAndPWord(String uName, String pWord); 
	
	public List<Integer> getAllAdminIds(); 

}
