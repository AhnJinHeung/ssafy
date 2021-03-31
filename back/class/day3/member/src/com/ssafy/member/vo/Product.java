package com.ssafy.member.vo;

// Data Bean, 기본 생성자, setter, getter 메소드
public class Product {
	private String name; // 멤버 변수, 프로퍼티
	private String pCode;
	private int price;
	
	public Product() {
		
	}
	
	public Product(String name, String pCode, int price) {
		this.name = name;
		this.pCode = pCode;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", pCode=" + pCode + ", price=" + price + "]";
	}
}
