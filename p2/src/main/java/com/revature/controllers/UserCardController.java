//package com.revature.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
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
//import org.springframework.web.bind.annotation.RestController;
//
//import com.revature.beans.UserCard;
//import com.revature.service.UserCardService;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4210")
//@RequestMapping(value = "/userCard")
//public class UserCardController {
//
//	// instance variables
//	private UserCardService ucs;
//
//	@Autowired // setter injection
//	public void setUserCardService(UserCardService ucs) {
//		this.ucs = ucs;
//	}
//
//	// methods
//	@RequestMapping(value = "/all", method = RequestMethod.GET)
//	public ResponseEntity<List<UserCard>> getAllUserCards() {
//		return new ResponseEntity<>(ucs.getAllUserCards(), HttpStatus.OK);
//	}
//
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<UserCard> getUserById(@PathVariable int id) {
//		UserCard uc = ucs.getUserCardById(id);
//		if (uc == null) {
//			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//		} else {
//			return new ResponseEntity<>(uc, HttpStatus.OK);
//		}
//	}
//
//	// rewrite the above to use a query string
//	// (will also work for form data passed in request body)
//	// Use this format: http://localhost:8089/P2/userCard/byId?id=68
//	@GetMapping(value = "/byId")
//	public ResponseEntity<UserCard> getCardByIdWithQueryString(@RequestParam int id) {
//		UserCard uc = ucs.getUserCardById(id);
//		if (uc == null) {
//			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//		} else {
//			return new ResponseEntity<>(uc, HttpStatus.OK);
//		}
//	}
//	
//	@PostMapping
//	public ResponseEntity<String> createUserCard(@RequestBody UserCard userCard){
//		ResponseEntity<String> resp = null;
//		try {
//			ucs.addUserCard(userCard);
//			resp = new ResponseEntity<>("USER-CARD RECORD CREATED SUCCESSFULLY", HttpStatus.OK);
//		} catch (Exception e) {
//			resp = new ResponseEntity<>("FAILED TO CREATE USER-CARD RECORD", HttpStatus.BAD_REQUEST);
//		}
//		return resp;
//	}
//	
//	@PutMapping
//	public ResponseEntity<String> updateCard(@RequestBody UserCard userCard){
//		ResponseEntity<String> resp = null;
//		try {
//			ucs.updateUserCard(userCard);
//			resp = new ResponseEntity<>("USER-CARD RECORD UPDATED SUCCESSFULLY", HttpStatus.OK);
//		} catch (Exception e) {
//			resp = new ResponseEntity<>("FAILED TO UPDATE USER-CARD RECORD", HttpStatus.BAD_REQUEST);
//		}
//		return resp;
//	}
//	
//	@DeleteMapping
//	public ResponseEntity<String> deleteUserCard(@RequestBody UserCard userCard){
//		ResponseEntity<String> resp = null;
//		try {
//			ucs.deleteUserCard(userCard);
//			resp = new ResponseEntity<>("USER-CARD RECORD DELETED SUCCESSFULLY", HttpStatus.OK);
//		} catch (Exception e) {
//			resp = new ResponseEntity<>("FAILED TO DELETE USER-CARD RECORD", HttpStatus.BAD_REQUEST);
//		}
//		return resp;
//	}
//
//}
