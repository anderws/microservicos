package com.estudo.hrworker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.hrworker.entities.Worker;
import com.estudo.hrworker.repositories.WorkRepository;

@RestController
@RequestMapping("/workers")
public class WorkController {
	
	@Autowired
	private WorkRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		Optional<Worker> worker = repository.findById(id);
		
		if(worker.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(worker.get());
	}

}
