package com.luis4j.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luis4j.users.entities.Role;
import com.luis4j.users.service.RoleService;

import jakarta.persistence.GeneratedValue;

@RestController
@RequestMapping("/roles")
public class RoleController {
	
	
	   @Autowired
	   private RoleService service;
	
	@GetMapping
	public ResponseEntity<List<Role>> getRoles () {
		
		return new ResponseEntity<List<Role>>(service.getRoles(), HttpStatus.OK); 
	}

	
	@PostMapping
	public ResponseEntity<Role> createRole (@RequestBody  Role role) {
		
	 return new ResponseEntity<Role>(service.createRole(role), HttpStatus.CREATED); 
	}
	
	
	@PutMapping("/{roleId}")
	
	public ResponseEntity<Role> updateRole( @PathVariable("roleId")Integer roleId,  @RequestBody Role role) {
		
		return new ResponseEntity<Role>(service.updateRole(roleId, role), HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/{roleId}")
	public ResponseEntity<Void> deleteRole (@PathVariable("roleId") Integer roleId ) {
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
