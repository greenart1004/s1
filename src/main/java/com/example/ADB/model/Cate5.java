package com.example.ADB.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Cate5 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String description;
	private int price;
	
	@Lob
	private String content1;
	@Lob
	private String content2;
	@Lob
	private String content3;	
	@Lob
	private String content4;	
	@Lob
	private String content5;	
	@Lob
	private String content6;
	@Lob
	private String content7;	
	@Lob
	private String content8;	
	@Lob
	private String content9;	
	@Lob
	private String content10;
	@Lob
	private String content11;
	@Lob
	private String content12;
	@Lob
	private String content13;	
	@Lob
	private String content14;	
	@Lob
	private String content15;	
	@Lob
	private String content16;
	@Lob
	private String content17;	
	@Lob
	private String content18;	
	@Lob
	private String content19;	
	@Lob
	private String content20;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image1;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image2;


//===============================================================================	

	public Long getId() {
		return id;
	}	
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public String getContent3() {
		return content3;
	}

	public void setContent3(String content3) {
		this.content3 = content3;
	}

	public String getContent4() {
		return content4;
	}

	public void setContent4(String content4) {
		this.content4 = content4;
	}

	public String getContent5() {
		return content5;
	}

	public void setContent5(String content5) {
		this.content5 = content5;
	}

	public String getContent6() {
		return content6;
	}

	public void setContent6(String content6) {
		this.content6 = content6;
	}

	public String getContent7() {
		return content7;
	}

	public void setContent7(String content7) {
		this.content7 = content7;
	}

	public String getContent8() {
		return content8;
	}

	public void setContent8(String content8) {
		this.content8 = content8;
	}

	public String getContent9() {
		return content9;
	}

	public void setContent9(String content9) {
		this.content9 = content9;
	}

	public String getContent10() {
		return content10;
	}

	public void setContent10(String content10) {
		this.content10 = content10;
	}

	public String getContent11() {
		return content11;
	}

	public void setContent11(String content11) {
		this.content11 = content11;
	}

	public String getContent12() {
		return content12;
	}

	public void setContent12(String content12) {
		this.content12 = content12;
	}

	public String getContent13() {
		return content13;
	}

	public void setContent13(String content13) {
		this.content13 = content13;
	}

	public String getContent14() {
		return content14;
	}

	public void setContent14(String content14) {
		this.content14 = content14;
	}

	public String getContent15() {
		return content15;
	}

	public void setContent15(String content15) {
		this.content15 = content15;
	}

	public String getContent16() {
		return content16;
	}

	public void setContent16(String content16) {
		this.content16 = content16;
	}

	public String getContent17() {
		return content17;
	}

	public void setContent17(String content17) {
		this.content17 = content17;
	}

	public String getContent18() {
		return content18;
	}

	public void setContent18(String content18) {
		this.content18 = content18;
	}

	public String getContent19() {
		return content19;
	}

	public void setContent19(String content19) {
		this.content19 = content19;
	}

	public String getContent20() {
		return content20;
	}

	public void setContent20(String content20) {
		this.content20 = content20;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", content1=" + content1 + ", content2=" + content2 + ", content3=" + content3 + ", content4="
				+ content4 + ", content5=" + content5 + ", content6=" + content6 + ", content7=" + content7
				+ ", content8=" + content8 + ", content9=" + content9 + ", content10=" + content10 + ", content11="
				+ content11 + ", content12=" + content12 + ", content13=" + content13 + ", content14=" + content14
				+ ", content15=" + content15 + ", content16=" + content16 + ", content17=" + content17 + ", content18="
				+ content18 + ", content19=" + content19 + ", content20=" + content20 + ", image=" + image + ", image1="
				+ image1 + ", image2=" + image2 + "]";
	}
	
}