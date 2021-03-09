package com.estudo.payroll.services;

import org.springframework.stereotype.Service;

import com.estudo.payroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workerId, int days) {
		return new Payment("Bob", 300.0, days);
	}
}
