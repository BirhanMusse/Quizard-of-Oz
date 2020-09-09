package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.revature.beans.User;


@CrossOrigin(origins = "http://localhost:4210")
@Controller
public class ProfileController {
	
	@GetMapping(value="/profile")
	public ModelAndView getProfilePage(@ModelAttribute("username") String username, ModelMap m) {
		
		m.addAttribute("username", username);
		
		return new ModelAndView("profile", m);
	}
	
	/*
	@GetMapping(value = "/login")
	public String getStaticLoginPage() {
		return "forward:/static/login.html";
	}
	*/
	
	//working logout May14 
	/*
	@GetMapping(value = "/logout")
	public String logout(HttpSession session, HttpServletRequest request) {
		
		session = request.getSession(false); 
		
		if (session !=null ) {
			session.invalidate();
		}
		
		return "forward:/static/base.html";
	}	
	*/
	/*
	@GetMapping(value="/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		User u = us.getUserById(id); 
		if (u == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); 
		} else {
			return new ResponseEntity<>(u, HttpStatus.OK); 
		}
	}
	*/
	
	
	// copy1
	/*
	@GetMapping(value = "/logout")
	public ResponseEntity<String> logout( HttpSession session, HttpServletRequest request) {
		
		session = request.getSession(false); 
		
		if (session !=null ) {
			
			session.invalidate();
			
		}
		if (session == null) {
			
			return new ResponseEntity<>("LOGGED OUT", HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity<>("STILL LOGGEDIN", HttpStatus.BAD_REQUEST); 
			

		}
		
	}	
	*/
}
