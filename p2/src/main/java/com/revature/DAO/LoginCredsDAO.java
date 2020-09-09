package com.revature.DAO;

import java.util.List;

import com.revature.beans.LoginCreds;

public interface LoginCredsDAO {
	
	public LoginCreds getLoginCredsById(int id); 
	
	public List<LoginCreds> getAllLoginCreds(); 
	
	public void addLoginCreds(LoginCreds loginCreds); 
	
	public boolean updateLoginCreds(LoginCreds loginCreds); 
	
	public void deleteLoginCreds(LoginCreds loginCreds); 
}
