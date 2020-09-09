package com.revature.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ConnectionUtil {

	private ConnectionUtil() {
		super(); 
	}
	
	private static SessionFactory sessionFactory; 
	
	public static SessionFactory getSessionFactory() {
		
		if (sessionFactory == null) {
			// if no SessionFactory has been created, create one
			Properties prop = new Properties();
			InputStream in = ConnectionUtil.class.getClassLoader().getResourceAsStream("config.properties"); 
			try {
				prop.load(in);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); 
			} catch (ClassNotFoundException e){
				System.out.println("Error: unable to load diver class!");
			}
			Configuration c = new Configuration(); 
			// grab credentials and URL from environment variables 
			c.setProperty("hibernate.connection.username", prop.getProperty("db.user"));
			c.setProperty("hibernate.connection.password", prop.getProperty("db.password"));
			c.setProperty("hibernate.connection.url", prop.getProperty("db.url")); 
			c.configure(); 
			
			sessionFactory = c.buildSessionFactory(); 

		}
		
		return sessionFactory; 
		
	}
	
}



