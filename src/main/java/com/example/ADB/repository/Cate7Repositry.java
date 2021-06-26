package com.example.ADB.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ADB.model.Cate7;


public interface Cate7Repositry extends JpaRepository<Cate7, Long> {

	List<Cate7> findByName(String name);
	List<Cate7> findByNameOrDescription(String name, String description);
	
	Page<Cate7> findByNameContainingOrDescriptionContaining(String name, String description, Pageable Pageable);

}
