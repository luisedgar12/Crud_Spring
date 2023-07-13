package com.luis4j.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.luis4j.users.entities.Address;
import com.luis4j.users.service.AddressService;

@RestController
@RequestMapping("/users/{userId}/profiles/{profileId}/addresses")
public class AddresController {
	
	
	@Autowired
	 private AddressService address;
	
	
	@GetMapping
	public ResponseEntity<List<Address>> findAddressesByProfileAndUserId(@PathVariable("userId") Integer userId,
			@PathVariable("profileId") Integer profileId){
  return new ResponseEntity<List<Address>>(address.findAddressesByProfileAndUserId(userId,profileId), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Address> create(@PathVariable("userId") Integer userId,
			@PathVariable("profileId") Integer profileId, @RequestBody Address adrees) {
		
		
		return new ResponseEntity<Address>(address.createAddress(userId, profileId, adrees), HttpStatus.CREATED);
	}
	
	
}
