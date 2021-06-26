package com.example.ADB.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ADB.model.Cate1;


public interface Cate1Repositry extends JpaRepository<Cate1, Long> {

	List<Cate1> findByName(String name);
	List<Cate1> findByNameOrDescription(String name, String description);
	
	Page<Cate1> findByNameContainingOrDescriptionContaining(String name, String description, Pageable Pageable);

}




















