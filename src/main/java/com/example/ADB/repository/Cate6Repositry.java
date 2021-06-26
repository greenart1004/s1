package com.example.ADB.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ADB.model.Cate5;
import com.example.ADB.model.Cate6;


public interface Cate6Repositry extends JpaRepository<Cate6, Long> {

	List<Cate6> findByName(String name);
	List<Cate6> findByNameOrDescription(String name, String description);
	
	Page<Cate6> findByNameContainingOrDescriptionContaining(String name, String description, Pageable Pageable);

}
