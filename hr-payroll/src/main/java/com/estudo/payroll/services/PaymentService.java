package com.estudo.payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.payroll.entities.Payment;
import com.estudo.payroll.entities.Worker;
import com.estudo.payroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	
	@Autowired
	WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
