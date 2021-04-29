package com.ssafy.model.dto;

public class Product {
	private String id;
	private String name;
	private String company;
	private int price;
	private String description;
	
	public Product() {}

	public Product(String id, String name, String company, int price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.price = price;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", company=" + company + ", price=" + price + ", description="
				+ description + "]";
	}
}
