package com.example.ADB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ADB.model.Cate1;
import com.example.ADB.model.Cate2;
import com.example.ADB.model.Cate3;
import com.example.ADB.model.Cate4;
import com.example.ADB.model.Cate5;
import com.example.ADB.model.Cate6;
import com.example.ADB.model.Cate7;
import com.example.ADB.repository.Cate1Repositry;
import com.example.ADB.repository.Cate2Repositry;
import com.example.ADB.repository.Cate3Repositry;
import com.example.ADB.repository.Cate4Repositry;
import com.example.ADB.repository.Cate5Repositry;
import com.example.ADB.repository.Cate6Repositry;
import com.example.ADB.repository.Cate7Repositry;


@Controller
public class HomeController {


		@Autowired
		private Cate1Repositry cate1Repositry;
		
		@Autowired
		private Cate2Repositry cate2Repositry;
	    
		@Autowired
		private Cate3Repositry cate3Repositry;
		
		@Autowired
		private Cate4Repositry cate4Repositry;
		
		@Autowired
		private Cate5Repositry cate5Repositry;
		
		@Autowired
		private Cate6Repositry cate6Repositry;
		
		@Autowired
		private Cate7Repositry cate7Repositry;		
		
		@GetMapping("/index.html")
	    public String index(Model model, @PageableDefault(size=6) Pageable pageable, 
				@RequestParam(required=false, defaultValue="") String searchText) {

			//데이타관련
			Page<Cate1> cates1;
	    	if(searchText == "") {
	    		cates1 = cate1Repositry.findAll(pageable);
			}else{
				cates1 = cate1Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
			}
	    	
	    	model.addAttribute("cates1", cates1);

	    	
	    	//데이타관련
			Page<Cate2> cates2;
	    	if(searchText == "") {
	    		cates2 = cate2Repositry.findAll(pageable);
			}else{
				cates2 = cate2Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
			}
	    	
	    	model.addAttribute("cates2", cates2);
	    	
	    	
	    	//데이타관련
			Page<Cate3> cates3;
	    	if(searchText == "") {
	    		cates3 = cate3Repositry.findAll(pageable);
			}else{
				cates3 = cate3Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
			}
	    	
	    	model.addAttribute("cates3", cates3);
	    	
	    	//데이타관련
			Page<Cate4> cates4;
	    	if(searchText == "") {
	    		cates4 = cate4Repositry.findAll(pageable);
			}else{
				cates4 = cate4Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
			}
	    	
	    	model.addAttribute("cates4", cates4);
	    	
	    	
	    	//데이타관련
			Page<Cate5> cates5;
	    	if(searchText == "") {
	    		cates5 = cate5Repositry.findAll(pageable);
			}else{
				cates5 = cate5Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
			}
	    	
	    	model.addAttribute("cates5", cates5);
	    	
	    	
		    	//데이타관련
			Page<Cate6> cates6;
	    	if(searchText == "") {
	    		cates6 = cate6Repositry.findAll(pageable);
			}else{
				cates6 = cate6Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
			}
	    	
	    	model.addAttribute("cates6", cates6);
	    	
	    	//데이타관련
			Page<Cate7> cates7;
	    	if(searchText == "") {
	    		cates7 = cate7Repositry.findAll(pageable);
			}else{
				cates7 = cate7Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
			}
	    	
	    	model.addAttribute("cates7", cates7);
			
			
			return "index";
		}
		
	 		
		@GetMapping("/")
	    public String list(Model model, @PageableDefault(size=6) Pageable pageable, 
			@RequestParam(required=false, defaultValue="") String searchText){
			
			//데이타관련
			Page<Cate1> cates1;
	    	if(searchText == "") {
	    		cates1 = cate1Repositry.findAll(pageable);
			}else{
				cates1 = cate1Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
			}
	    	
	    	model.addAttribute("cates1", cates1);

	    	
	    	//데이타관련
			Page<Cate2> cates2;
	    	if(searchText == "") {
	    		cates2 = cate2Repositry.findAll(pageable);
			}else{
				cates2 = cate2Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
			}
	    	
	    	model.addAttribute("cates2", cates2);
	    	
	    	
	    	//데이타관련
			Page<Cate3> cates3;
	    	if(searchText == "") {
	    		cates3 = cate3Repositry.findAll(pageable);
			}else{
				cates3 = cate3Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
			}
	    	
	    	model.addAttribute("cates3", cates3);
	    	
	    	//데이타관련
			Page<Cate4> cates4;
	    	if(searchText == "") {
	    		cates4 = cate4Repositry.findAll(pageable);
			}else{
				cates4 = cate4Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
			}
	    	
	    	model.addAttribute("cates4", cates4);
	    	
	    	
	    	//데이타관련
			Page<Cate5> cates5;
	    	if(searchText == "") {
	    		cates5 = cate5Repositry.findAll(pageable);
			}else{
				cates5 = cate5Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
			}
	    	
	    	model.addAttribute("cates5", cates5);
	    	
	    	
		   	//데이타관련
			Page<Cate6> cates6;
	    	if(searchText == "") {
	    		cates6 = cate6Repositry.findAll(pageable);
			}else{
				cates6 = cate6Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
			}
	    	model.addAttribute("cates6", cates6);
	    	
	    	
  	    	//데이타관련
			Page<Cate7> cates7;
	    	if(searchText == "") {
	    		cates7 = cate7Repositry.findAll(pageable);
			}else{
				cates7 = cate7Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
			}
	    	
	    	model.addAttribute("cates7", cates7);
	    	
	    	
			return "index";
		}
	}
