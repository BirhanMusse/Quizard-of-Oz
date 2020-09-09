//package com.revature.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//
//import com.revature.beans.User;
//import com.revature.service.UserService;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4210")
//@RequestMapping(value="/user")
//public class UserController {
//	
//	//instance variables 
//	private UserService us; 
//	
//	
//	@Autowired // setter injection
//	public void setUserService(UserService us) {
//		this.us = us;
//	}
//	
//	//methods
//	
////	@CrossOrigin(origins = "http://localhost:4203")
//	@RequestMapping(value="/all", method=RequestMethod.GET)
//	public ResponseEntity<List<User>> getAllUsers() {
//		return new ResponseEntity<>(us.getAllUsers(), HttpStatus.OK);
//	}
//	
//	@GetMapping(value="/{id}")
//	public ResponseEntity<User> getUserById(@PathVariable int id) {
//		User u = us.getUserById(id); 
//		if (u == null) {
//			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); 
//		} else {
//			return new ResponseEntity<>(u, HttpStatus.OK); 
//		}
//	}
//	
//	//rewrite the above to use a query string 
//	//(will also work for form data passed in request body)
//	//Use this format: http://localhost:8089/P2/user/byId?id=68
//	@GetMapping(value="/byId")
//	public ResponseEntity<User> getUserByIdWithQueryString(@RequestParam int id){
//		User u = us.getUserById(id);
//		if (u == null) {
//			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//		} else {
//			return new ResponseEntity<>(u, HttpStatus.OK);
//		}
//	}
////	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
//	@PostMapping
//	public ResponseEntity<String> createUser(@RequestBody User user){
//		ResponseEntity<String> resp = null;
//		try {
//			us.addUser(user);
//			resp = new ResponseEntity<>("USER CREATED SUCCESSFULLY", HttpStatus.OK);
//		} catch (Exception e) {
//			resp = new ResponseEntity<>("FAILED TO CREATE USER", HttpStatus.BAD_REQUEST);
//		}
//		return resp;
//	}
//	
//	@PutMapping
//	public ResponseEntity<String> updateUser(@RequestBody User user){
//		ResponseEntity<String> resp = null;
//		try {
//			us.updateUser(user);
//			resp = new ResponseEntity<>("USER UPDATED SUCCESSFULLY", HttpStatus.OK);
//		} catch (Exception e) {
//			resp = new ResponseEntity<>("FAILED TO UPDATE USER", HttpStatus.BAD_REQUEST);
//		}
//		return resp;
//	}
//	
//	@DeleteMapping
//	public ResponseEntity<String> deleteUser(@RequestBody User user){
//		ResponseEntity<String> resp = null;
//		try {
//			us.deleteUser(user);
//			resp = new ResponseEntity<>("USER DELETED SUCCESSFULLY", HttpStatus.OK);
//		} catch (Exception e) {
//			resp = new ResponseEntity<>("FAILED TO DELETE USER", HttpStatus.BAD_REQUEST);
//		}
//		return resp;
//	}
//
//}
