package com.example.ADB.repository;




import java.util.List;
//import java.awt.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ADB.model.Product;


//@Repository
public interface ProductRepositry extends JpaRepository<Product, Long> {

	List<Product> findByName(String name);
	List<Product> findByNameOrDescription(String name, String description);
	
	Page<Product> findByNameContainingOrDescriptionContaining(String name, String description, Pageable Pageable);

}
