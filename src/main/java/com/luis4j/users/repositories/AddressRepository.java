package com.luis4j.users.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.luis4j.users.entities.Address;


@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>  {
	
	
	@Query("SELECT a FROM Address a WHERE a.profile.user.id=?1 AND  a.profile.id=?2 ")
	List<Address> findByProfileId(Integer userId, Integer profileId);

}
