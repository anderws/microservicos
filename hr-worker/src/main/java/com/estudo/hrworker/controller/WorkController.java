package com.estudo.hrworker.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	/**
	@Value("${test.config}")
	private String testConfig;
	
	@GetMapping("/configs")
	public ResponseEntity<Void> getConfig(){
		System.out.println("Config: "+ testConfig);
		return ResponseEntity.noContent().build();
	}
	
	**/
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		Optional<Worker> worker = repository.findById(id);
		/**
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		**/
		if(worker.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(worker.get());
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}

}
