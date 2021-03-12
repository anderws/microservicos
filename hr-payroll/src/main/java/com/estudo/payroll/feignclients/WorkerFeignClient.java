package com.estudo.payroll.feignclients;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.estudo.payroll.entities.Worker;

@Component
@FeignClient(name = "hr-worker", path="workers")
@RibbonClient(name = "hr-worker")
public interface WorkerFeignClient {

	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id);
}
