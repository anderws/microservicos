package com.estudo.payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.payroll.entities.Payment;
import com.estudo.payroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	PaymentService service;
		
	@GetMapping("/{workerId}/days/{days}")
	 @HystrixCommand(fallbackMethod = "getPaymentFallback")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}
	
	public ResponseEntity<Payment> getPaymentFallback(Long workerId, Integer days){
		
			Payment payment = new Payment("Brann", 400.0, days);
			return ResponseEntity.ok(payment);
	}

}
