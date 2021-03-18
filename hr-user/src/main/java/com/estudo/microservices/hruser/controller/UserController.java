package com.estudo.microservices.hruser.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.microservices.hruser.entities.User;
import com.estudo.microservices.hruser.repositories.UserRepository;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository repository;

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		Optional<User> user = repository.findById(id);

		if(user.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user.get());
	}

	@GetMapping("/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		User user = repository.findByEmail(email);

		if(user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}

}
