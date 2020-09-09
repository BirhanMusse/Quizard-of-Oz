package com.revature.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.DAO.UserDAO;
import com.revature.DAO.UserDAOImpl;
import com.revature.DAO.UserTypeDAO;
import com.revature.DAO.UserTypeDAOImpl;
import com.revature.beans.LoginCreds;
import com.revature.beans.User;
import com.revature.beans.UserType;
import com.revature.util.ConnectionUtil;

@Service
public class UserServiceImpl implements UserService {

	//instance variables 
	private UserDAO ud = new UserDAOImpl();
	private UserTypeDAO utd = new UserTypeDAOImpl(); 
	
	//methods
	public User getUserById(int id) {
		return ud.getUserById(id); 
	}
	
	@Override
	public User getUserByUnameAndPWord(String uName, String pWord) {
		return ud.getUserbyUnameAndPword(uName, pWord); 
	}
	
	public List<User> getAllUsers() {
		return ud.getAllUsers(); 
	}
	
	public void addUser(User user) {
		//ud.addUser(user);
		//User u = new User("Stu", "Stevens", "SStevens@futuretech.com",new UserType(2, "mentor"), new LoginCreds(0, "SStevens", "secret"), 0);
		 
		System.out.println(user);
		
		//start session 
		SessionFactory sf = ConnectionUtil.getSessionFactory();
		Session s2 = sf.openSession();
		Transaction tx2 = s2.beginTransaction();
		
		//persist login creds to DB
		s2.save(user.getLoginCreds()); 
		
		System.out.println(user.getLoginCreds().getId());
		
		//grab id to session 
		int userLoginCredsId = user.getLoginCreds().getId(); 
		
		//
		UserType userType = utd.getUserTypeById(user.getUserType().getId()); 
		
		User u2 = new User(user.getFirstName(), user.getLastName(), user.getEmail()); 
		
		//u2.setLoginCreds(lcd.getLoginCredsById(userLoginCredsId));
		u2.setLoginCreds(user.getLoginCreds());
		u2.setUserType(userType);
		
		System.out.println(u2);
		
		s2.persist(u2);
		
		//close 
		tx2.commit();
		s2.close();
	}
	
	public boolean updateUser(User user) {
		return ud.updateUser(user); 
	}
	
	public void deleteUser(User user) {
		ud.deleteUser(user);
	}

	@Override
	public List<Integer> getAllAdminIds() {
		return ud.getAllAdminIds(); 
	}
	
}
