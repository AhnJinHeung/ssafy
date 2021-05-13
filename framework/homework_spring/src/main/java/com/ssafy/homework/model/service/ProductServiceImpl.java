package com.ssafy.homework.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.homework.model.Product;
import com.ssafy.homework.model.SearchCondition;
import com.ssafy.homework.model.repository.ProductRepo;
import com.ssafy.util.PageNavigation;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Product> selectAll() throws Exception {
		return sqlSession.getMapper(ProductRepo.class).selectAll();
	}

	@Override
	public Product select(String code) throws Exception {
		return sqlSession.getMapper(ProductRepo.class).select(code);
	}

	@Override
	public int insert(Product product, MultipartFile attach) throws Exception {
		if (attach != null) {
			String fileName = attach.getOriginalFilename();
			
			byte[] bytes = attach.getBytes();
			
			product.setFile(bytes);
			product.setFileName(fileName);
			product.setFileSize(bytes.length);
		}
		
		return sqlSession.getMapper(ProductRepo.class).insert(product);
	}

	@Override
	public int update(Product product, MultipartFile attach) throws Exception {
		if (attach != null) {
			String fileName = attach.getOriginalFilename();
			
			byte[] bytes = attach.getBytes();
			
			product.setFile(bytes);
			product.setFileName(fileName);
			product.setFileSize(bytes.length);
		}
		
		return sqlSession.getMapper(ProductRepo.class).update(product);
	}

	@Override
	public int delete(String code) throws Exception {
		return sqlSession.getMapper(ProductRepo.class).delete(code);
	}

	@Override
	public Map<String, Object> pagingSearch(SearchCondition condition) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int currentPage = condition.getPg();
		int totalCount = sqlSession.getMapper(ProductRepo.class).getTotalCount(condition);
		
		int start = (currentPage - 1) * condition.getSpp();
		condition.setStart(start);
		
		PageNavigation pageNavigation = new PageNavigation(currentPage, totalCount);
		
		List<Product> list = sqlSession.getMapper(ProductRepo.class).search(condition);
		
		map.put("navigation", pageNavigation);
		map.put("products", list);
		
		return map;
	}
	
}
