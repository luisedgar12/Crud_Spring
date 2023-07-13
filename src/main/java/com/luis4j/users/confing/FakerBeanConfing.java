package com.luis4j.users.confing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

@Configuration
public class FakerBeanConfing {

	
	
	@Bean
	public Faker getFaker() {
		
		return new Faker();
	}
	
	
}
