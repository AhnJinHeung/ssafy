package com.ssafy.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.model.dto.Product;
import com.ssafy.model.dto.SearchCondition;

public interface ProductService {
	public List<Product> selectAll() throws Exception;
	
	public Product select(String code) throws Exception;
	
	public int insert(Product product, MultipartFile attach) throws Exception;
	
	public int update(Product product, MultipartFile attach) throws Exception;
	
	public int delete(String code) throws Exception;
	
	public Map<String, Object> pagingSearch(SearchCondition condition) throws Exception;
}
