package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public ProductRepo getRepo() throws Exception {
		return productRepo; // 확인
	}

	@Override
	public List<Product> selectAll() throws Exception {
		return productRepo.selectAll();
	}

	@Override
	public Product select(String id) throws Exception {
		return productRepo.select(id);
	}

	@Override
	public int insert(Product product) throws Exception {
		return productRepo.insert(product);
	}

	@Override
	public int update(Product product) throws Exception {
		return productRepo.update(product);
	}

	@Override
	public int delete(String id) throws Exception {
		return productRepo.delete(id);
	}
	
}
