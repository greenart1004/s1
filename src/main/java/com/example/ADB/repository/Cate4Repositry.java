package com.example.ADB.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ADB.model.Cate4;


public interface Cate4Repositry extends JpaRepository<Cate4, Long> {

	List<Cate4> findByName(String name);
	List<Cate4> findByNameOrDescription(String name, String description);
	
	Page<Cate4> findByNameContainingOrDescriptionContaining(String name, String description, Pageable Pageable);

}
