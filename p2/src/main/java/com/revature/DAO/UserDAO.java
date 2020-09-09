package com.revature.DAO;

import java.util.List;

import com.revature.beans.User;

public interface UserDAO {

	//crud 
	public User getUserById(int id); 
	
	public List<User> getAllUsers(); 
	
	public void addUser(User user); 
	
	public boolean updateUser(User user); 
	
	public void deleteUser(User user); 
	
	//extras 
	public User getUserbyUnameAndPword(String uName, String pWord); 
	
	public List<Integer> getAllAdminIds(); 
}
