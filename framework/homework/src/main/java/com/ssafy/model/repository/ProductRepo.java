package com.ssafy.model.repository;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.Product;

public interface ProductRepo {
	public List<Product> selectAll() throws SQLException;
	
	public Product select(String id) throws SQLException;
	
	public int insert(Product product) throws SQLException;
	
	public int update(Product product) throws SQLException;
	
	public int delete(String id) throws SQLException;
}
