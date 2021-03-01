package com.ssafy.hw09;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 5210849075306655487L;
	private int number;
	private String name;
	private int price;
	private int cnt;
	
	public Product(int number, String name, int price, int cnt) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return number + "\t|\t " + name + "\t|\t " + price + "\t|\t " + cnt;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public boolean equals(Object obj) {
		Product newProduct = (Product)obj;
		return this.number == newProduct.number && this.name.equals(newProduct.name);
	}
}
