package com.example.ADB.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.ToString;


@Entity
@ToString
public class Board {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Size(max=30, message = "제목은 2자이상 30자 이하입니다.")
	private String title;
	
	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
	private String content;
	
	
	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
	private String content1;
//	
//	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content2;
//	
//	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content3;
//	
//	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content4;
//	
//	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content5;
//	
//	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content6;
//	
//	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content7;
//	
//	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content8;
//	
//	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content9;
//	
//	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content10;
//	
//	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content11;
//	
//	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content12;
//	
//	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content13;
//	
//	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content14;
//	
//	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content15;
//	
//	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content16;
//	
//	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content17;
//	
//	@Size( max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content18;
//	
//	@Size(min=2, max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content19;
//	
//	@Size(min=2, max=300, message = "제목은 2자이상 300자 이하입니다.")
//	private String content20;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}
//
//	public String getContent2() {
//		return content2;
//	}
//
//	public void setContent2(String content2) {
//		this.content2 = content2;
//	}
//
//	public String getContent3() {
//		return content3;
//	}
//
//	public void setContent3(String content3) {
//		this.content3 = content3;
//	}
//
//	public String getContent4() {
//		return content4;
//	}
//
//	public void setContent4(String content4) {
//		this.content4 = content4;
//	}
//
//	public String getContent5() {
//		return content5;
//	}
//
//	public void setContent5(String content5) {
//		this.content5 = content5;
//	}
//
//	public String getContent6() {
//		return content6;
//	}
//
//	public void setContent6(String content6) {
//		this.content6 = content6;
//	}
//
//	public String getContent7() {
//		return content7;
//	}
//
//	public void setContent7(String content7) {
//		this.content7 = content7;
//	}
//
//	public String getContent8() {
//		return content8;
//	}
//
//	public void setContent8(String content8) {
//		this.content8 = content8;
//	}
//
//	public String getContent9() {
//		return content9;
//	}
//
//	public void setContent9(String content9) {
//		this.content9 = content9;
//	}
//
//	public String getContent10() {
//		return content10;
//	}
//
//	public void setContent10(String content10) {
//		this.content10 = content10;
//	}
//
//	public String getContent11() {
//		return content11;
//	}
//
//	public void setContent11(String content11) {
//		this.content11 = content11;
//	}
//
//	public String getContent12() {
//		return content12;
//	}
//
//	public void setContent12(String content12) {
//		this.content12 = content12;
//	}
//
//	public String getContent13() {
//		return content13;
//	}
//
//	public void setContent13(String content13) {
//		this.content13 = content13;
//	}
//
//	public String getContent14() {
//		return content14;
//	}
//
//	public void setContent14(String content14) {
//		this.content14 = content14;
//	}
//
//	public String getContent15() {
//		return content15;
//	}
//
//	public void setContent15(String content15) {
//		this.content15 = content15;
//	}
//
//	public String getContent16() {
//		return content16;
//	}
//
//	public void setContent16(String content16) {
//		this.content16 = content16;
//	}
//
//	public String getContent17() {
//		return content17;
//	}
//
//	public void setContent17(String content17) {
//		this.content17 = content17;
//	}
//
//	public String getContent18() {
//		return content18;
//	}
//
//	public void setContent18(String content18) {
//		this.content18 = content18;
//	}
//
//	public String getContent19() {
//		return content19;
//	}
//
//	public void setContent19(String content19) {
//		this.content19 = content19;
//	}
//
//	public String getContent20() {
//		return content20;
//	}
//
//	public void setContent20(String content20) {
//		this.content20 = content20;
//	}
	
	
		
}