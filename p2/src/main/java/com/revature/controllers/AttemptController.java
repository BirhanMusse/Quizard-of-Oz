package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Attempt;
import com.revature.service.AttemptService;

@RestController
@CrossOrigin(origins = "http://localhost:4210")
@RequestMapping(value = "/attempt")
public class AttemptController {

	// instance variables
	private AttemptService as;

//	@Autowired // setter injection
//	public void setAttemptService(AttemptService as) {
//		this.as = as;
//	}

	// methods
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Attempt>> getAllUsers() {
		return new ResponseEntity<>(as.getAllAttempts(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Attempt> getUserById(@PathVariable int id) {
		Attempt a = as.getAttemptById(id);
		if (a == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(a, HttpStatus.OK);
		}
	}

	// rewrite the above to use a query string
	// (will also work for form data passed in request body)
	// Use this format: http://localhost:8089/P2/Attempt/byId?id=68
	@GetMapping(value = "/byId")
	public ResponseEntity<Attempt> getAttemptByIdWithQueryString(@RequestParam int id) {
		Attempt a = as.getAttemptById(id);
		if (a == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(a, HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody Attempt Attempt){
		ResponseEntity<String> resp = null;
		try {
			as.addAttempt(Attempt);
			resp = new ResponseEntity<>("Attempt CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO CREATE Attempt", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@PutMapping
	public ResponseEntity<String> updateAttempt(@RequestBody Attempt Attempt){
		ResponseEntity<String> resp = null;
		try {
			as.updateAttempt(Attempt);
			resp = new ResponseEntity<>("Attempt UPDATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO UPDATE Attempt", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteAttempt(@RequestBody Attempt Attempt){
		ResponseEntity<String> resp = null;
		try {
			as.deleteAttempt(Attempt);
			resp = new ResponseEntity<>("Attempt DELETED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("FAILED TO DELETE Attempt", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}	
}
