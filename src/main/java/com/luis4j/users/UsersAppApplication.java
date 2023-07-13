 package com.luis4j.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;
import com.luis4j.users.entities.User;
import com.luis4j.users.repositories.UserRepository;

@SpringBootApplication
public class UsersAppApplication implements ApplicationRunner{
	
	
	
	@Autowired 
	private Faker faker;
	
	@Autowired
	private UserRepository rrepository; 

	
	public static void main(String[] args) {
		SpringApplication.run(UsersAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		
		for(int i=0; i<50; i++) {
			
			User user= new User();
			user.setPassword(faker.dragonBall().character());
			user.setUsername(faker.name().username());
			
			
			 rrepository.save(user);
		}
	
	}

	
	


}
