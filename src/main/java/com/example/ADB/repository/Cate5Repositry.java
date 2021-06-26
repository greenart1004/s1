package com.example.ADB.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ADB.model.Cate5;


public interface Cate5Repositry extends JpaRepository<Cate5, Long> {

	List<Cate5> findByName(String name);
	List<Cate5> findByNameOrDescription(String name, String description);
	
	Page<Cate5> findByNameContainingOrDescriptionContaining(String name, String description, Pageable Pageable);

}
