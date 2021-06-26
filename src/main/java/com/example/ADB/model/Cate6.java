package com.example.ADB.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Cate6 {
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
		return "Cate6 [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", content1=" + content1 + ", content2=" + content2 + ", content3=" + content3 + ", content4="
				+ content4 + ", content5=" + content5 + ", image=" + image + ", image1=" + image1 + ", image2=" + image2
				+ "]";
	}

}