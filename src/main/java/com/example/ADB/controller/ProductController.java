package com.example.ADB.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.ADB.model.Board;
import com.example.ADB.model.Product;
import com.example.ADB.repository.BoardRepository;
import com.example.ADB.repository.ProductRepositry;
import com.example.ADB.service.ProductService;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@Autowired
	private ProductRepositry productRepository;
	
//======================================================================================================	

    @GetMapping("/product_list")
	public String listProducts(Model model, @PageableDefault(size=5) Pageable pageable, 
			@RequestParam(required=false, defaultValue="") String searchText){
    	Page<Product> products;
    	
    	
    	if(searchText == "") {
			 products = productRepository.findAll(pageable);
		}else{
			 products = productRepository.findByNameContainingOrDescriptionContaining(searchText, searchText, pageable);
		}
		
//		products.getTotalPages(); // �쟾泥닿굔�닔
		int startPage = Math.max(1, products.getPageable().getPageNumber() - 10);
		int endPage = Math.min(products.getTotalPages(), products.getPageable().getPageNumber() + 10);
		
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("products", products);

		return "product/product_list";
	}
		

  //======================================================================================================	

    @GetMapping("/product_detail")
    public String listProducts2(Model model, @RequestParam(required=false) Long id) {   // �옄�꽭�엳蹂닿린
    
    	Product product2 = productService.detail(id);
        
     	model.addAttribute("product2", product2);

      return "product/product_detail";
	}
 
 
  //======================================================================================================	

    @GetMapping("/product_form")
    public String form(Model model, @RequestParam(required=false) Long id) {
    	if(id == null) {
	        model.addAttribute("product", new Product());
    	}else{
    		Product product = productRepository.findById(id).orElse(null);
	        model.addAttribute("product", product);
    	}
    	   	
    	return "product/product_form";
	}

    
    @PostMapping("/product_form")
    public String form1(@ModelAttribute Product product, Model model,
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
			@RequestParam(required=false) Long id
						
    		) {
  
    	productService.saveProductToDB1(id, name, description, price,content1,content2,content3,content4,content5,content6,content7,content8,content9,content10,content11,content12,content13,content14,content15,content16,content17,content18,content19,content20);

    		Product product2 = productService.detail(id);

    		
    		
    		model.addAttribute("product2", product2);		
    		
     	return "product/product_detail";
	}

//	=========================================================
	@GetMapping("/product_add")
	public String addProduct(){

		return "product/product_add";
	}
	

    
    @PostMapping("/product_add")
    public String saveProduct(
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
    	
    	productService.saveProductToDB(file, file1, file2, name, description, price,content1,content2,content3,content4,content5,content6,content7,content8,content9,content10,content11,content12,content13,content14,content15,content16,content17,content18,content19,content20);
    	
    	return "redirect:/product/product_list";
    }
        

//====================================================================================================    
    
    @GetMapping("/deleteProd/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
    	
    	productService.deleteProductById(id);
    	
    	return "redirect:/product/product_list" ;    		
    }
      
    
   
//	=========================================================   
//    @PostMapping("/changeName")
//    public String changePname(@RequestParam("id") Long id,
//    		@RequestParam("newPname") String name)
//    {
//    	productService.chageProductName(id, name);
//    	return "redirect:/listProducts.html";
//    }
//    @PostMapping("/changeDescription")
//    public String changeDescription(@RequestParam("id") Long id ,
//    		@RequestParam("newDescription") String description)
//    {
//    	productService.changeProductDescription(id, description);
//    	return "redirect:/listProducts.html";
//    }
//    
//    @PostMapping("/changePrice")
//    public String changePrice(@RequestParam("id") Long id ,
//    		@RequestParam("newPrice") int price)
//    {
//    	productService.changeProductPrice(id, price);
//    	return "redirect:/listProducts.html";
//    }
}
