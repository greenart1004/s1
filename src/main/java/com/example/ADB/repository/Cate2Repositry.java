package com.example.ADB.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.ADB.model.Cate2;


public interface Cate2Repositry extends JpaRepository<Cate2, Long> {

	List<Cate2> findByName(String name);
	List<Cate2> findByNameOrDescription(String name, String description);
	
	Page<Cate2> findByNameContainingOrDescriptionContaining(String name, String description, Pageable Pageable);

}
