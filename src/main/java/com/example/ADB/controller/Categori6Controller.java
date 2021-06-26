package com.example.ADB.controller;


import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.ADB.model.Cate6;
import com.example.ADB.repository.Cate6Repositry;




@Controller
@RequestMapping("/categori6")
public class Categori6Controller {

	@Autowired
	private Cate6Repositry cate6Repositry;
    
 
	//======================================================================================================	
	
	@GetMapping("/cate_6_index")
    public String list(Model model, @PageableDefault(size=12) Pageable pageable, 
			@RequestParam(required=false, defaultValue="") String searchText){
		
		//search 관련
		Page<Cate6> cates6;
    	if(searchText == "") {
    		cates6 = cate6Repositry.findAll(pageable);
		}else{
			cates6 = cate6Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
		}
	
    	// pager 관련
		int startPage = Math.max(1, cates6.getPageable().getPageNumber() - 10);
		int endPage = Math.min(cates6.getTotalPages(), cates6.getPageable().getPageNumber() + 10);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
	
		model.addAttribute("cates6", cates6);

		
		return "categori6/cate_6_index";
	}
    
	
	@GetMapping("/cate_6_list")
    public String list1(Model model, @PageableDefault(size=12) Pageable pageable, 
			@RequestParam(required=false, defaultValue="") String searchText){
		
		//search 관련
		Page<Cate6> cates6;
    	if(searchText == "") {
    		cates6 = cate6Repositry.findAll(pageable);
		}else{
			cates6 = cate6Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
		}
	
    	// pager 관련
		int startPage = Math.max(1, cates6.getPageable().getPageNumber() - 10);
		int endPage = Math.min(cates6.getTotalPages(), cates6.getPageable().getPageNumber() + 10);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("cates6", cates6);

		
		return "categori6/cate_6_list";
	}
	
	
	
//======================================================================================================	
    
	@GetMapping("/cate_6_add")
	public String addcate6(Model model, @RequestParam(required=false) Long id){
		if(id == null) {
            model.addAttribute("cates6", new Cate6());
    	}else{
    		Cate6 cates6 = cate6Repositry.findById(id).orElse(null);
            model.addAttribute("cates6", cates6);
    	}
		return "categori6/cate_6_add";
	}
	
    
    @PostMapping("/cate_6_add")
    public String savecate6(
    		@RequestParam("file") MultipartFile file,
    		@RequestParam("file1") MultipartFile file1,
    		@RequestParam("file2") MultipartFile file2,
    		@RequestParam("pname") String name,
    		@RequestParam("price") int price,
    		@RequestParam("description") String description,
    		@RequestParam("content1") String content1,   		
    		@RequestParam("content2") String content2,     		
    		@RequestParam("content3") String content3,      		
    		@RequestParam("content4") String content4,     		
    		@RequestParam("content5") String content5){
    	
		Cate6 p = new Cate6();
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		String fileName1 = StringUtils.cleanPath(file1.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			p.setImage1(Base64.getEncoder().encodeToString(file1.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String fileName2 = StringUtils.cleanPath(file2.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			p.setImage2(Base64.getEncoder().encodeToString(file2.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        p.setName(name);
        p.setPrice(price);
		p.setDescription(description);

        
        p.setContent1(content1);
        p.setContent2(content2);
        p.setContent3(content3);
        p.setContent4(content4);
        p.setContent5(content5);
        
        cate6Repositry.save(p);

	return "redirect:/categori6/cate_6_list";
    }
  
//======================================================================================================
    
  @GetMapping("/cate_6_form")
  public String form(Model model, @RequestParam(required=false) Long id) {
	  
  	if(id == null) {
        model.addAttribute("cate_6", new Cate6());
  	}else{
  		Cate6 cate_6 = cate6Repositry.findById(id).orElse(null);
        model.addAttribute("cate_6", cate_6);
  	}
  	   	
  	return "categori6/cate_6_form";
	}

  
  @PostMapping("/cate_6_form")
  public String form1(@ModelAttribute Cate6 cate6, Model model,
  		@RequestParam("name") String name,
  		@RequestParam("price") int price,
  		@RequestParam("description") String description,
  		@RequestParam("content1") String content1,   		
  		@RequestParam("content2") String content2,     		
  		@RequestParam("content3") String content3,      		
  		@RequestParam("content4") String content4,     		
  		@RequestParam("content5") String content5,
		@RequestParam(required=false) Long id) {

  		
  			Cate6 p = new Cate6();
  			
	  		  p = cate6Repositry.findById(id).get();
	  		  p.setDescription(description);
  		      p.setName(name);
  		      p.setPrice(price);
  		      
  		      p.setContent1(content1);
  		      p.setContent2(content2);
  		      p.setContent3(content3);
  		      p.setContent4(content4);
  		      p.setContent5(content5);
  		  	
  		    cate6Repositry.save(p);
  	  		
  		  Cate6  cate_6 = cate6Repositry.findById(id).get();
  		    
  		model.addAttribute("cate_6", cate_6);		
  		
   	return "redirect:/categori6/cate_6_list";
	}
  
  
  @GetMapping("/deleteProd/{id}")
  public String deletecate_6(@PathVariable("id") Long id){
  	
	  cate6Repositry.deleteById(id);
  	
  	return "redirect:/categori6/cate_6_list" ;    		
  }
 
}
