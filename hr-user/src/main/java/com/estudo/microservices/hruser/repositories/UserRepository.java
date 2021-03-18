package com.estudo.microservices.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.microservices.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
