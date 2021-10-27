package com.esprit.microservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.microservice.entities.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select c from User c where c.nom like :nom")
	public Page<User> candidatByNom(@Param("nom") String n, Pageable pageable);
}
