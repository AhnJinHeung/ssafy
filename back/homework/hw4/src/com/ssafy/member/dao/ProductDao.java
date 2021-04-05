package com.ssafy.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.member.dto.ProductDto;


public interface ProductDao {

//	상품 등록
	void registerProduct(ProductDto productDto) throws SQLException;
	
//	상품 목록
	List<ProductDto> listProduct() throws SQLException;
	
//	상품 조회
	ProductDto getProduct(int num) throws SQLException;
	
//	상품 수정
	void modifyProduct(ProductDto productDto) throws SQLException;
	
//	상품 삭제
	void deleteProduct(int num) throws SQLException;
	
//	상품 검색
	List<ProductDto> serchProduct(String key, String gubun) throws SQLException;
}
