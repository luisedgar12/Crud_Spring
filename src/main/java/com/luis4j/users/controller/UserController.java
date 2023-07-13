package com.luis4j.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luis4j.users.entities.User;
import com.luis4j.users.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
     @Autowired
	 private UserService service;
     
     
	@GetMapping
	public ResponseEntity<List<User>> getUsers(){
		
		return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId) {
		
		return new ResponseEntity<>(service.getById(userId), HttpStatus.OK);
	} 
	
	
	@GetMapping("/names")
	public ResponseEntity<List<String>> getNames() {
		
		return new ResponseEntity<List<String>>(service.getUsersnames(), HttpStatus.OK); 
	}
	
	@GetMapping("/username/{username}")
	
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
		
		return new ResponseEntity<>(service.getuserByUsername(username), HttpStatus.OK);
	}
	
	@DeleteMapping("/{username}")
	
	public ResponseEntity<Void> deleteUsername(@PathVariable("username") String username) {
		
		service.deleteUserByUsername(username);
		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
	}
	
}
