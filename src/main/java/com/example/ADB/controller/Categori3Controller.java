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

import com.example.ADB.model.Cate3;
import com.example.ADB.model.Cate3;
import com.example.ADB.repository.Cate3Repositry;


@Controller
@RequestMapping("/categori3")
public class Categori3Controller {

	@Autowired
	private Cate3Repositry Cate3Repositry;
    
 
	//======================================================================================================	
	
	@GetMapping("/cate_3_index")
    public String list(Model model, @PageableDefault(size=12) Pageable pageable, 
			@RequestParam(required=false, defaultValue="") String searchText){
		
		//search 愿��젴
		Page<Cate3> cates3;
    	if(searchText == "") {
    		cates3 = Cate3Repositry.findAll(pageable);
		}else{
			cates3 = Cate3Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
		}
	
    	// pager 愿��젴
		int startPage = Math.max(1, cates3.getPageable().getPageNumber() - 10);
		int endPage = Math.min(cates3.getTotalPages(), cates3.getPageable().getPageNumber() + 10);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
	
		model.addAttribute("cates3", cates3);

		
		return "categori3/cate_3_index";
	}
    
	
	@GetMapping("/cate_3_list")
    public String list1(Model model, @PageableDefault(size=12) Pageable pageable, 
			@RequestParam(required=false, defaultValue="") String searchText){
		
		//search 愿��젴
		Page<Cate3> cates3;
    	if(searchText == "") {
    		cates3 = Cate3Repositry.findAll(pageable);
		}else{
			cates3 = Cate3Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
		}
	
    	// pager 愿��젴
		int startPage = Math.max(1, cates3.getPageable().getPageNumber() - 10);
		int endPage = Math.min(cates3.getTotalPages(), cates3.getPageable().getPageNumber() + 10);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("cates3", cates3);

		
		return "categori3/cate_3_list";
	}
	
	
	
//======================================================================================================	
    
	@GetMapping("/cate_3_add")
	public String addCate3(Model model, @RequestParam(required=false) Long id){
		if(id == null) {
            model.addAttribute("cates3", new Cate3());
    	}else{
    		Cate3 cates3 = Cate3Repositry.findById(id).orElse(null);
            model.addAttribute("cates3", cates3);
    	}
		return "categori3/cate_3_add";
	}
	
    
    @PostMapping("/cate_3_add")
    public String saveCate3(
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
    		@RequestParam("content5") String content5, 
    		@RequestParam("content6") String content6,   		
    		@RequestParam("content7") String content7,     		
    		@RequestParam("content8") String content8,      		
    		@RequestParam("content9") String content9,     		
    		@RequestParam("content10") String content10,  
    		@RequestParam("content11") String content11,   		
    		@RequestParam("content12") String content12,     		
    		@RequestParam("content13") String content13,      		
    		@RequestParam("content14") String content14,     		
    		@RequestParam("content15") String content15,  
    		@RequestParam("content16") String content16,   		
    		@RequestParam("content17") String content17,     		
    		@RequestParam("content18") String content18,      		
    		@RequestParam("content19") String content19,     		
    		@RequestParam("content20") String content20){
    	
		Cate3 p = new Cate3();
		
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
        p.setContent6(content6);
        p.setContent7(content7);
        p.setContent8(content8);
        p.setContent9(content9);
        p.setContent10(content10);
        p.setContent11(content11);
        p.setContent12(content12);
        p.setContent13(content13);
        p.setContent14(content14);
        p.setContent15(content15);
        p.setContent16(content16);
        p.setContent17(content17);
        p.setContent18(content18);
        p.setContent19(content19);
        p.setContent20(content20);
        
        Cate3Repositry.save(p);

	return "redirect:/categori3/cate_3_list";
    }
  
//======================================================================================================
    
  @GetMapping("/cate_3_form")
  public String form(Model model, @RequestParam(required=false) Long id) {
	  
  	if(id == null) {
        model.addAttribute("cate_3", new Cate3());
  	}else{
  		Cate3 cate_3 = Cate3Repositry.findById(id).orElse(null);
        model.addAttribute("cate_3", cate_3);
  	}
  	   	
  	return "categori3/cate_3_form";
	}

  
  @PostMapping("/cate_3_form")
  public String form1(@ModelAttribute Cate3 Cate3, Model model,
  		@RequestParam("name") String name,
  		@RequestParam("price") int price,
  		@RequestParam("description") String description,
  		@RequestParam("content1") String content1,   		
  		@RequestParam("content2") String content2,     		
  		@RequestParam("content3") String content3,      		
  		@RequestParam("content4") String content4,     		
  		@RequestParam("content5") String content5, 
  		@RequestParam("content6") String content6,   		
  		@RequestParam("content7") String content7,     		
  		@RequestParam("content8") String content8,      		
  		@RequestParam("content9") String content9,     		
  		@RequestParam("content10") String content10,  
  		@RequestParam("content11") String content11,   		
  		@RequestParam("content12") String content12,     		
  		@RequestParam("content13") String content13,      		
  		@RequestParam("content14") String content14,     		
  		@RequestParam("content15") String content15,  
  		@RequestParam("content16") String content16,   		
  		@RequestParam("content17") String content17,     		
  		@RequestParam("content18") String content18,      		
  		@RequestParam("content19") String content19,     		
  		@RequestParam("content20") String content20,
		@RequestParam(required=false) Long id) {

  		
  			Cate3 p = new Cate3();
  			
	  		  p = Cate3Repositry.findById(id).get();
	  		  p.setDescription(description);
  		      p.setName(name);
  		      p.setPrice(price);
  		      
  		      p.setContent1(content1);
  		      p.setContent2(content2);
  		      p.setContent3(content3);
  		      p.setContent4(content4);
  		      p.setContent5(content5);
  		      p.setContent6(content6);
  		      p.setContent7(content7);
  		      p.setContent8(content8);
  		      p.setContent9(content9);
  		      p.setContent10(content10);
  		      p.setContent11(content11);
  		      p.setContent12(content12);
  		      p.setContent13(content13);
  		      p.setContent14(content14);
  		      p.setContent15(content15);
  		      p.setContent16(content16);
  		      p.setContent17(content17);
  		      p.setContent18(content18);
  		      p.setContent19(content19);
  		      p.setContent20(content20);

  		  	
  		    Cate3Repositry.save(p);
  	  		
  		  Cate3  cate_3 = Cate3Repositry.findById(id).get();
  		    
  		model.addAttribute("cate_3", cate_3);		
  		
   	return "redirect:/categori3/cate_3_list";
	}
  
  
  @GetMapping("/deleteProd/{id}")
  public String deletecate_3(@PathVariable("id") Long id){
  	
	  Cate3Repositry.deleteById(id);
  	
  	return "redirect:/categori3/cate_3_list" ;    		
  }
 
}
