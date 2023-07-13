package com.luis4j.users.confing;

import java.io.ObjectInputFilter.Config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfing {

	
	@Bean
	public CacheManager getCache() {
		
		return new ConcurrentMapCacheManager("users"); 
	}
	
	
	
}
