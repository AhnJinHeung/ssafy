package com.ssafy.homework.model;


public class Product {
	private String code;
	private String name;
	private String company;
	private int price;
	private String description;
	private byte[] file;
	private String fileName;
	private long fileSize;
	
	public Product() {}

	public Product(String code, String name, String company, int price, String description, byte[] file, String fileName, long fileSize) {
		super();
		this.code = code;
		this.name = name;
		this.company = company;
		this.price = price;
		this.description = description;
		this.file = file;
		this.fileName = fileName;
		this.fileSize = fileSize;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
	
	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
}
