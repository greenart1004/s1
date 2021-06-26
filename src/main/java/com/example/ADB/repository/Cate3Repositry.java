package com.example.ADB.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ADB.model.Cate3;


public interface Cate3Repositry extends JpaRepository<Cate3, Long> {

	List<Cate3> findByName(String name);
	List<Cate3> findByNameOrDescription(String name, String description);
	
	Page<Cate3> findByNameContainingOrDescriptionContaining(String name, String description, Pageable Pageable);

}
