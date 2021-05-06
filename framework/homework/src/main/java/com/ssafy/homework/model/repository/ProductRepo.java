package com.ssafy.homework.model.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.homework.model.Product;
import com.ssafy.homework.model.SearchCondition;

public interface ProductRepo {
	public List<Product> selectAll() throws SQLException;
	
	public Product select(String code) throws SQLException;
	
	public int insert(Product product) throws SQLException;
	
	public int update(Product product) throws SQLException;
	
	public int delete(String code) throws SQLException;
	
	public int getTotalCount(SearchCondition condition) throws SQLException;
	
	public List<Product> search(SearchCondition condition) throws SQLException;
}
