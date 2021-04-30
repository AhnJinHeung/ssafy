package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repository.ProductRepo;

public interface ProductService {
	public List<Product> selectAll() throws Exception;
	
	public Product select(String id) throws Exception;
	
	public int insert(Product product) throws Exception;
	
	public int update(Product product) throws Exception;
	
	public int delete(String id) throws Exception;
}
