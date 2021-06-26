//package com.example.ADB.service;
//
//import java.io.IOException;
//import java.util.Base64;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.example.ADB.model.Board;
//import com.example.ADB.model.Product;
//import com.example.ADB.repository.BoardRepository;
//import com.example.ADB.repository.ProductRepositry;
//
//
//
//@Service
//public class BoardService {
//	
//	@Autowired
//	private BoardRepository boardRepository;
//	
//	
//	
////	public void  saveProductToDB(MultipartFile file,
////			String name,String description,int price){
////		
////		Product p = new Product();
////		
////		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
////		if(fileName.contains(".."))
////		{
////			System.out.println("not a a valid file");
////		}
////		try {
////			p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////		p.setDescription(description);
////        p.setName(name);
////        p.setPrice(price);
////        
////        productRepositry.save(p);
////	}
//	
//				//	public List<Board> getAllBoard() {
//				//		return boardRepository.findAll();
//				//	}
//
//	
//    public void deleteBoardById(Long id) {
//    	boardRepository.deleteById(id);
//    }
//
//
////	public Optional<Board> BoardDetail(Long id) {
////		Optional<Board> board = boardRepository.findById(id);
////		return board.isPresent() ? board : null;
////  return boardRepository.findById(id); 
//		
//		}
////
////
////	public void saveProductToDB1(Long id ,String name, String desc, int price) {
////		Product p = new Product();
////    	p = productRepositry.findById(id).get();
////    	p.setName(name);
////    	p.setDescription(desc); 
////    	p.setPrice(price);
////
////    	
////    	productRepositry.save(p);
////		
////	}
//
//
//
//}
//
//
//
//    
//    
//    
////    
////    public void chageProductName(Long id ,String name)
////    {
////    	Product1 p = new Product1();
////    	p = productRepositry.findById(id).get();
////    	p.setName(name);
////    	productRepositry.save(p);    
////    }
//    
//    
//    
////    public void changeProductDescription(Long id , String description)
////    {
////    	Product1 p = new Product1();
////    	p = productRepositry.findById(id).get();
////    	p.setDescription(description);
////    	productRepositry.save(p);
////    }
////    public void changeProductPrice(Long id,int price)
////    {
////    	Product1 p = new Product1();
////    	p = productRepositry.findById(id).get();
////    	p.setPrice(price);
////    	productRepositry.save(p);
////    }
