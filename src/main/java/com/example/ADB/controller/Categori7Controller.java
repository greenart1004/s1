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

import com.example.ADB.model.Cate7;
import com.example.ADB.repository.Cate7Repositry;




@Controller
@RequestMapping("/categori7")
public class Categori7Controller {

	@Autowired
	private Cate7Repositry cate7Repositry;
    
 
	//======================================================================================================	
	
	@GetMapping("/cate_7_index")
    public String list(Model model, @PageableDefault(size=2) Pageable pageable, 
			@RequestParam(required=false, defaultValue="") String searchText){
		
		//search 관련
		Page<Cate7> cates7;
    	if(searchText == "") {
    		cates7 = cate7Repositry.findAll(pageable);
		}else{
			cates7 = cate7Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
		}
	
    	// pager 관련
		int startPage = Math.max(1, cates7.getPageable().getPageNumber() - 10);
		int endPage = Math.min(cates7.getTotalPages(), cates7.getPageable().getPageNumber() + 10);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
	
		model.addAttribute("cates7", cates7);

		
		return "categori7/cate_7_index";
	}
    
	
	@GetMapping("/cate_7_list")
    public String cate_7_list(Model model, @PageableDefault(size=12) Pageable pageable, 
			@RequestParam(required=false, defaultValue="") String searchText){
		
		//search 관련
		Page<Cate7> cates7;
    	if(searchText == "") {
    		cates7 = cate7Repositry.findAll(pageable);
		}else{
			cates7 = cate7Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
		}
	
    	// pager 관련
		int startPage = Math.max(1, cates7.getPageable().getPageNumber() - 10);
		int endPage = Math.min(cates7.getTotalPages(), cates7.getPageable().getPageNumber() + 10);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("cates7", cates7);

		
		return "categori7/cate_7_list";
	}
	
	
	
//======================================================================================================	
    
	@GetMapping("/cate_7_add")
	public String addCate7(Model model, @RequestParam(required=false) Long id){
		if(id == null) {
            model.addAttribute("cates7", new Cate7());
    	}else{
    		Cate7 cates7 = cate7Repositry.findById(id).orElse(null);
            model.addAttribute("cates7", cates7);
    	}
		return "categori7/cate_7_add";
	}
	
    
    @PostMapping("/cate_7_add")
    public String saveCate7(
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
    	
		Cate7 p = new Cate7();
		
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
        
        cate7Repositry.save(p);

	return "redirect:/categori7/cate_7_list";
    }
  
//======================================================================================================
    
  @GetMapping("/cate_7_form")
  public String cate_7_form1(Model model, @RequestParam(required=false) Long id) {
	  
  	if(id == null) {
        model.addAttribute("cate_7", new Cate7());
  	}else{
  		Cate7 cate_7 = cate7Repositry.findById(id).orElse(null);
        model.addAttribute("cate_7", cate_7);
  	}
  	   	
  	return "categori7/cate_7_form";
	}

  
  @PostMapping("/cate_7_form")
  public String cate_7_form(@ModelAttribute Cate7 Cate7, Model model,
  		@RequestParam("name") String name,
  		@RequestParam("price") int price,
  		@RequestParam("description") String description,
  		@RequestParam("content1") String content1,   		
  		@RequestParam("content2") String content2,     		
  		@RequestParam("content3") String content3,      		
  		@RequestParam("content4") String content4,     		
  		@RequestParam("content5") String content5,
		@RequestParam(required=false) Long id) {

  		
  			Cate7 p = new Cate7();
  			
	  		  p = cate7Repositry.findById(id).get();
	  		  p.setDescription(description);
  		      p.setName(name);
  		      p.setPrice(price);
  		      
  		      p.setContent1(content1);
  		      p.setContent2(content2);
  		      p.setContent3(content3);
  		      p.setContent4(content4);
  		      p.setContent5(content5);
  		  	
  		    cate7Repositry.save(p);
  	  		
  		  Cate7  cate_7 = cate7Repositry.findById(id).get();
  		    
  		model.addAttribute("cate_7", cate_7);		
  		
   	return "redirect:/categori7/cate_7_list";
	}
  
  
  @GetMapping("/deleteProd/{id}")
  public String deletecate_7(@PathVariable("id") Long id){
  	
	  cate7Repositry.deleteById(id);
  	
  	return "redirect:/categori7/cate_7_list" ;    		
  }
 
}
