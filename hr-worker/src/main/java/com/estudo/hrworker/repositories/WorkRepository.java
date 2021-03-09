package com.estudo.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.hrworker.entities.Worker;

public interface WorkRepository extends JpaRepository<Worker, Long> {

}
