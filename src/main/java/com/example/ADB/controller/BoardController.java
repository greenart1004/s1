package com.example.ADB.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

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

import com.example.ADB.model.Board;
import com.example.ADB.model.Product;
import com.example.ADB.repository.BoardRepository;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;
    
    @GetMapping("/board_list")
    public String listBoard(Model model, @PageableDefault(size=7) Pageable pageable, 
		@RequestParam(required=false, defaultValue="") String searchText){
			
		Page<Board> boards;
	    	
    	if(searchText == "") {
    		boards = boardRepository.findAll(pageable);
		}else{
			boards = boardRepository.findByTitleContainingOrContentContaining(searchText, searchText, pageable);
		}
		
  		int startPage = Math.max(1, boards.getPageable().getPageNumber() - 10);
		int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 10);

		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);

		model.addAttribute("boards", boards);

        return "board/board_list";
	}
		
    @GetMapping("/board_list2")
    public String listBoard2(Model model, @PageableDefault(size=7) Pageable pageable, 
		@RequestParam(required=false, defaultValue="") String searchText){
			
		Page<Board> boards;
	    	
    	if(searchText == "") {
    		boards = boardRepository.findAll(pageable);
		}else{
			boards = boardRepository.findByTitleContainingOrContentContaining(searchText, searchText, pageable);
		}
		
  		int startPage = Math.max(1, boards.getPageable().getPageNumber() - 10);
		int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 10);

		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);

		model.addAttribute("boards", boards);

        return "board/board_list2";
	}
    
//==========================================================================================================
    @GetMapping("/board_form")
    public String board_form(Model model, @RequestParam(required=false) Long id) {
    	if(id == null) {
	        model.addAttribute("Board", new Board());
    	}else{
    		Board boards = boardRepository.findById(id).orElse(null);
	        model.addAttribute("boards", boards);
    	}
    	   	
    	return "board/board_form";
	}
    
    
    
     @PostMapping("/board_form")
     public String board_form1(@ModelAttribute Board board, Model model,
     		@RequestParam("title") String title,
     		@RequestParam("content") String content,
     		@RequestParam("content1") String content1,   		
//     		@RequestParam("content2") String content2,     		
//     		@RequestParam("content3") String content3,      		
//     		@RequestParam("content4") String content4,     		
//     		@RequestParam("content5") String content5, 
//     		@RequestParam("content6") String content6,   		
//     		@RequestParam("content7") String content7,     		
//     		@RequestParam("content8") String content8,      		
//     		@RequestParam("content9") String content9,     		
//     		@RequestParam("content10") String content10,  
//     		@RequestParam("content11") String content11,   		
//     		@RequestParam("content12") String content12,     		
//     		@RequestParam("content13") String content13,      		
//     		@RequestParam("content14") String content14,     		
//     		@RequestParam("content15") String content15,  
//     		@RequestParam("content16") String content16,   		
//     		@RequestParam("content17") String content17,     		
//     		@RequestParam("content18") String content18,      		
//     		@RequestParam("content19") String content19,     		
//     		@RequestParam("content20") String content20,
 			@RequestParam(required=false) Long id) {
    	 
    	 Board p = new Board();
    	 
     	p = boardRepository.findById(id).get();
     
	 	p.setTitle(title);
        p.setContent(content);

         p.setContent1(content1);
//         p.setContent2(content2);
//         p.setContent3(content3);
//         p.setContent4(content4);
//         p.setContent5(content5);
//         p.setContent6(content6);
//         p.setContent7(content7);
//         p.setContent8(content8);
//         p.setContent9(content9);
//         p.setContent10(content10);
//         p.setContent11(content11);
//         p.setContent12(content12);
//         p.setContent13(content13);
//         p.setContent14(content14);
//         p.setContent15(content15);
//         p.setContent16(content16);
//         p.setContent17(content17);
//         p.setContent18(content18);
//         p.setContent19(content19);
//         p.setContent20(content20);

     	
         boardRepository.save(p);
    	 
    	 Optional<Board> boards = boardRepository.findById(id);
     	 model.addAttribute("boards", boards);	
         
     	 return "board/board_detail";
 	}
 	

     
   //==========================================================================================================

     @GetMapping("/board_detail")
     public String BoardDetail(Model model, @RequestParam(required=false) Long id) {   // �옄�꽭�엳蹂닿린
     
    	 Board board = boardRepository.findById(id).orElse(null);
     	
      	model.addAttribute("board", board);

       return "board/board_detail";
 	}     
     
     //==========================================================================================================
     @GetMapping("/board_add")
 	public String addBoard(){

 		return "board/board_add";
 	}
 	
     
     @PostMapping("/board_add")
     public String saveBoard(
     		@RequestParam("title") String title,
     		@RequestParam("content") String content,
     		@RequestParam("content1") String content1   		
//     		@RequestParam("content2") String content2,     		
//     		@RequestParam("content3") String content3,      		
//     		@RequestParam("content4") String content4,     		
//     		@RequestParam("content5") String content5, 
//     		@RequestParam("content6") String content6,   		
//     		@RequestParam("content7") String content7,     		
//     		@RequestParam("content8") String content8,      		
//     		@RequestParam("content9") String content9,     		
//     		@RequestParam("content10") String content10,  
//     		@RequestParam("content11") String content11,   		
//     		@RequestParam("content12") String content12,     		
//     		@RequestParam("content13") String content13,      		
//     		@RequestParam("content14") String content14,     		
//     		@RequestParam("content15") String content15,  
//     		@RequestParam("content16") String content16,   		
//     		@RequestParam("content17") String content17,     		
//     		@RequestParam("content18") String content18,      		
//     		@RequestParam("content19") String content19,     		
//     		@RequestParam("content20") String content20
     		){
     	
    		 Board p = new Board();
    			
    		 	p.setTitle(title);
    	        p.setContent(content);
    	        
    	        p.setContent1(content1);
//    	        p.setContent2(content2);
//    	        p.setContent3(content3);
//    	        p.setContent4(content4);
//    	        p.setContent5(content5);
//    	        p.setContent6(content6);
//    	        p.setContent7(content7);
//    	        p.setContent8(content8);
//    	        p.setContent9(content9);
//    	        p.setContent10(content10);
//    	        p.setContent11(content11);
//    	        p.setContent12(content12);
//    	        p.setContent13(content13);
//    	        p.setContent14(content14);
//    	        p.setContent15(content15);
//    	        p.setContent16(content16);
//    	        p.setContent17(content17);
//    	        p.setContent18(content18);
//    	        p.setContent19(content19);
//    	        p.setContent20(content20);
    	        
    	        boardRepository.save(p);
    	
    	
     	return "redirect:/board/board_list";
     }
     
     
     
     
//====================================================================================================    
     
     @GetMapping("/deleteProd/{id}")
     public String deleteBoard(@PathVariable("id") Long id){
     	
    	 boardRepository.deleteById(id);

     	return "redirect:/board/board_list" ;    		
     }     
}

