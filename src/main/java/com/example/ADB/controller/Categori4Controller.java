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

import com.example.ADB.model.Cate4;
import com.example.ADB.model.Cate4;
import com.example.ADB.repository.Cate4Repositry;


@Controller
@RequestMapping("/categori4")
public class Categori4Controller {

	@Autowired
	private Cate4Repositry Cate4Repositry;
    
 
	//======================================================================================================	
	
	@GetMapping("/cate_4_index")
    public String list(Model model, @PageableDefault(size=12) Pageable pageable, 
			@RequestParam(required=false, defaultValue="") String searchText){
		
		//search 愿��젴
		Page<Cate4> cates4;
    	if(searchText == "") {
    		cates4 = Cate4Repositry.findAll(pageable);
		}else{
			cates4 = Cate4Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
		}
	
    	// pager 愿��젴
		int startPage = Math.max(1, cates4.getPageable().getPageNumber() - 10);
		int endPage = Math.min(cates4.getTotalPages(), cates4.getPageable().getPageNumber() + 10);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
	
		model.addAttribute("cates4", cates4);

		
		return "categori4/cate_4_index";
	}
    
	
	@GetMapping("/cate_4_list")
    public String list1(Model model, @PageableDefault(size=12) Pageable pageable, 
			@RequestParam(required=false, defaultValue="") String searchText){
		
		//search 愿��젴
		Page<Cate4> cates4;
    	if(searchText == "") {
    		cates4 = Cate4Repositry.findAll(pageable);
		}else{
			cates4 = Cate4Repositry.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
		}
	
    	// pager 愿��젴
		int startPage = Math.max(1, cates4.getPageable().getPageNumber() - 10);
		int endPage = Math.min(cates4.getTotalPages(), cates4.getPageable().getPageNumber() + 10);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("cates4", cates4);

		
		return "categori4/cate_4_list";
	}
	
	
	
//======================================================================================================	
    
	@GetMapping("/cate_4_add")
	public String addCate4(Model model, @RequestParam(required=false) Long id){
		if(id == null) {
            model.addAttribute("cates4", new Cate4());
    	}else{
    		Cate4 cates4 = Cate4Repositry.findById(id).orElse(null);
            model.addAttribute("cates4", cates4);
    	}
		return "categori4/cate_4_add";
	}
	
    
    @PostMapping("/cate_4_add")
    public String saveCate4(
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
    	
		Cate4 p = new Cate4();
		
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
        
        Cate4Repositry.save(p);

	return "redirect:/categori4/cate_4_list";
    }
  
//======================================================================================================
    
  @GetMapping("/cate_4_form")
  public String form(Model model, @RequestParam(required=false) Long id) {
	  
  	if(id == null) {
        model.addAttribute("cate_4", new Cate4());
  	}else{
  		Cate4 cate_4 = Cate4Repositry.findById(id).orElse(null);
        model.addAttribute("cate_4", cate_4);
  	}
  	   	
  	return "categori4/cate_4_form";
	}

  
  @PostMapping("/cate_4_form")
  public String form1(@ModelAttribute Cate4 Cate4, Model model,
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

  		
  			Cate4 p = new Cate4();
  			
	  		  p = Cate4Repositry.findById(id).get();
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

  		  	
  		    Cate4Repositry.save(p);
  	  		
  		  Cate4  cate_4 = Cate4Repositry.findById(id).get();
  		    
  		model.addAttribute("cate_4", cate_4);		
  		
   	return "redirect:/categori4/cate_4_list";
	}
  
  
  @GetMapping("/deleteProd/{id}")
  public String deletecate_4(@PathVariable("id") Long id){
  	
	  Cate4Repositry.deleteById(id);
  	
  	return "redirect:/categori4/cate_4_list" ;    		
  }
 
}
