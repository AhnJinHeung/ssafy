package com.ssafy.member.dto;

public class ProductDto {
	private String num;
	private String name;
	private String price;
	private String discription;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	@Override
	public String toString() {
		return "ProductDto [num=" + num + ", name=" + name + ", price=" + price + ", discription=" + discription + "]";
	}
}
