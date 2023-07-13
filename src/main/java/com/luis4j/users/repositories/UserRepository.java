package com.luis4j.users.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.luis4j.users.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public Optional<User> findByusername(String username);
	
	
	@Query("SELECT u.username FROM User u")
	public List<String> findUsersname(); 
	
	
	
}
