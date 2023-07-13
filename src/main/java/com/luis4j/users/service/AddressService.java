package com.luis4j.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.luis4j.users.entities.Address;
import com.luis4j.users.entities.Profile;
import com.luis4j.users.repositories.AddressRepository;
import com.luis4j.users.repositories.ProfileRepository;

@Service
public class AddressService {
	
	
	@Autowired
	private AddressRepository addressrepository;
	
	@Autowired ProfileRepository profilerepository;

	public List<Address> findAddressesByProfileAndUserId(Integer userId, Integer profileId) {
	
	return	addressrepository.findByProfileId(userId, profileId);
	
		
	}
	
	
	
	public Address createAddress(  Integer userId, Integer profileId, Address address) {
	
		Optional<Profile> result = profilerepository.findBygetByUserIdAndProfileId(userId, profileId);
		
		if (result.isPresent()) {
			address.setProfile(result.get());
			
			return addressrepository.save(address);
			
		}else {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Profile %d  and user %d not found",profileId, userId ));
		}
	  
		
	}
	
	
	
	
	
	
}
