package com.ssafy.member.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.member.dto.ProductDto;

public interface ProductService {

//	상품 등록
	void registerProduct(ProductDto productDto) throws Exception;
	
//	상품 목록
	List<ProductDto> listProduct() throws Exception;
	
//	상품 조회
	ProductDto getProduct(int num) throws Exception;
	
//	상품 수정
	void modifyProduct(ProductDto productDto) throws Exception;
	
//	상품 삭제
	void deleteProduct(int num) throws Exception;
	
//	상품 검색
	List<ProductDto> serchProduct(String key, String gubun) throws Exception;
}
