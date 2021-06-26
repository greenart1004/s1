package com.example.ADB.service;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.ADB.model.Product;
import com.example.ADB.repository.ProductRepositry;



@Service
public class ProductService {
	
	@Autowired
	private ProductRepositry productRepositry;
	
	public void  saveProductToDB(MultipartFile file,MultipartFile file1,MultipartFile file2,
			String name,String description,int price,
			String content1,String content2,String content3,String content4,String content5,String content6,String content7,String content8,String content9,String content10,String content11,String content12,String content13,String content14,String content15,String content16,String content17,String content18,String content19,String content20){
		
		Product p = new Product();
		
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
        
        productRepositry.save(p);
	}
	
	
	public Page<Product> getAllProduct(Pageable pageable){
		
		return productRepositry.findAll(PageRequest.of(1, 20));
		
	}
	
	
    public void deleteProductById(Long id) {
    	productRepositry.deleteById(id);
    }


	public Optional<Product> detail(Long id) {
		return productRepositry.findById(id);
//				.orElseThrow(()->{
//					return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을수 없습니다.");
//				});
		}


	public void saveProductToDB1(Long id, String name,String description,int price,
			String content1,String content2,String content3,String content4,String content5,String content6,String content7,String content8,String content9,String content10,String content11,String content12,String content13,String content14,String content15,String content16,String content17,String content18,String content19,String content20) {
		// TODO Auto-generated method stub
		Product p = new Product();
    	p = productRepositry.findById(id).get();
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

    	
    	productRepositry.save(p);
		
	}

}



    
    
    
//    
//    public void chageProductName(Long id ,String name)
//    {
//    	Product1 p = new Product1();
//    	p = productRepositry.findById(id).get();
//    	p.setName(name);
//    	productRepositry.save(p);    
//    }
    
    
    
//    public void changeProductDescription(Long id , String description)
//    {
//    	Product1 p = new Product1();
//    	p = productRepositry.findById(id).get();
//    	p.setDescription(description);
//    	productRepositry.save(p);
//    }
//    public void changeProductPrice(Long id,int price)
//    {
//    	Product1 p = new Product1();
//    	p = productRepositry.findById(id).get();
//    	p.setPrice(price);
//    	productRepositry.save(p);
//    }
