package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.model.Credentials;

@Service 
public class AdminAuthService {
	public boolean isAnAdmin(Credentials creds) {

		List adminIdList;

		// set of credentials from login
		String username = creds.getUsername();
		String password = creds.getPassword();

		//
		System.out.println(username);
		System.out.println(password);

		// instance of employee if valid credentials
		UserService us = new UserServiceImpl();
		User user = us.getUserByUnameAndPWord(username, password);

		adminIdList = us.getAllAdminIds();

		//
		if (adminIdList.contains(user.getId())) {
			return true;
		}
		return false;
	}
}
