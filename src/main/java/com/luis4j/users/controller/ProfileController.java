package com.luis4j.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luis4j.users.entities.Profile;
import com.luis4j.users.entities.User;
import com.luis4j.users.repositories.UserRepository;
import com.luis4j.users.service.ProfileService;
@RequestMapping("/users/{userId}/profiles")
@RestController
public class ProfileController {
	
  @Autowired
  private ProfileService service; 

  
  
  @GetMapping("/{profileId}")
  
  ResponseEntity<Profile> getId(@PathVariable("userId") Integer userId,@PathVariable("profileId") Integer profileId) {
	  
	  return new ResponseEntity<Profile>(service.getByUserIdAndProfileId(userId,profileId), HttpStatus.OK);
  }
  
  
  
  

  @PostMapping
  public ResponseEntity<Profile> create(@PathVariable("userId") Integer userId, @RequestBody Profile profile) {
	  
	  return new ResponseEntity<Profile>(service.create(userId, profile), HttpStatus.CREATED);
  }
	
  
  

}
