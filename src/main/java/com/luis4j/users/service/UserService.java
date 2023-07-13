package com.luis4j.users.service;

import java.lang.ProcessHandle.Info;
import java.util.List;

import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.luis4j.users.entities.User;
import com.luis4j.users.repositories.UserRepository;

@Service
public class UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userrepository;
	
	
	public List<User> getUsers() {
		return userrepository.findAll();
		
	}
	
	
	public List<String> getUsersnames() {
		
		return userrepository.findUsersname();
	}
	
	
	@CacheEvict("users")
	public void deleteUserByUsername ( String username ) {
		
		User user = getuserByUsername(username);
		userrepository.delete(user);
	}
	
	public User getById(Integer userId ) {
		
		return userrepository.findById(userId).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
				
				String.format("User %d not found", userId)) );
		
		
	}

      @Cacheable("users")
	 public User getuserByUsername(String username) {
    	  log.info("Getting user by username {}", username);
    	 
    	  try {
    		  Thread.sleep(7000);
    	  }catch (InterruptedException e) {
			e.printStackTrace();
		}
   
    	  
	 	return userrepository.findByusername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
				 String.format("User %s not found", username)));
	 }
	
	


	
}
