package com.ssafy.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Product> selectAll() throws Exception {
		return sqlSession.getMapper(ProductRepo.class).selectAll();
	}

	@Override
	public Product select(String id) throws Exception {
		return sqlSession.getMapper(ProductRepo.class).select(id);
	}

	@Override
	public int insert(Product product) throws Exception {
		return sqlSession.getMapper(ProductRepo.class).insert(product);
	}

	@Override
	public int update(Product product) throws Exception {
		return sqlSession.getMapper(ProductRepo.class).update(product);
	}

	@Override
	public int delete(String id) throws Exception {
		return sqlSession.getMapper(ProductRepo.class).delete(id);
	}
	
}
