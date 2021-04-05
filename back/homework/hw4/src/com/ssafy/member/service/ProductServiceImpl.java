package com.ssafy.member.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.member.dao.ProductDao;
import com.ssafy.member.dao.ProductDaoImpl;
import com.ssafy.member.dto.ProductDto;


public class ProductServiceImpl implements ProductService {

	private static ProductService productService;
	
	private ProductServiceImpl() {}
	
	public static ProductService getProductService() {
		if(productService == null)
			productService = new ProductServiceImpl();
		return productService;
	}
	
	@Override
	public void registerProduct(ProductDto productDto) throws Exception {
		ProductDaoImpl.getProductDao().registerProduct(productDto);
	}
	
	@Override
	public List<ProductDto> listProduct() throws Exception {
		List<ProductDto> list = null;
		
		ProductDao dao = ProductDaoImpl.getProductDao();
		list = dao.listProduct();
		
		return list;
	}

	@Override
	public ProductDto getProduct(int num) throws Exception {
		ProductDto dto = null;
		
		ProductDao dao = ProductDaoImpl.getProductDao();
		dto = dao.getProduct(num);
		
		return dto;
	}

	@Override
	public void modifyProduct(ProductDto guestBookDto) throws Exception {
		ProductDaoImpl.getProductDao().modifyProduct(guestBookDto);
	}

	@Override
	public void deleteProduct(int num) throws Exception {
		ProductDaoImpl.getProductDao().deleteProduct(num);
	}

	public List<ProductDto> serchProduct(String key, String gubun) throws Exception {
		return ProductDaoImpl.getProductDao().serchProduct(key, gubun);
	}
}
