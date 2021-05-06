package com.ssafy.homework.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.homework.model.Product;
import com.ssafy.homework.model.SearchCondition;
import com.ssafy.homework.model.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/admin")
@Api("어드민 컨트롤러 API V1")
@CrossOrigin("*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private ProductService productService;
	
	@ApiOperation(value="상품목록", notes="상품의 <big>전체목록</big>을 반환해 줍니다.")
	@PostMapping(value = "/product/search")
	public ResponseEntity<Map<String, Object>> search(@RequestBody SearchCondition condition) {
		try {
			Map<String, Object> map = productService.pagingSearch(condition);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="상품검색", notes="상품 코드를 이용해서 상품을 검색합니다.")
	@GetMapping(value = "/product/{code}")
	public ResponseEntity<Product> select(@PathVariable("code") String code) {
		try {
			Product product = productService.select(code);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="상품등록", notes="상품 정보를 받아서 DB에 저장합니다.")
	@PostMapping(value = "/product")
	public ResponseEntity<Map<String, Object>> regist( @RequestBody Product product, @RequestBody MultipartFile attach) {
		try {
			productService.insert(product, attach);
			SearchCondition condition = new SearchCondition();
			Map<String, Object> map = productService.pagingSearch(condition);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="상품수정", notes="상품 정보를 수정합니다.")
	@PutMapping(value = "/product")
	public ResponseEntity<Map<String, Object>> modify(@RequestBody Product product, @RequestBody MultipartFile attach) {
		try {
			productService.update(product, attach);
			SearchCondition condition = new SearchCondition();
			Map<String, Object> map = productService.pagingSearch(condition);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="상품삭제", notes="상품을 삭제합니다.")
	@DeleteMapping(value = "/product/{code}")
	public ResponseEntity<Map<String, Object>> remove(@PathVariable("code") String code) {
		try {
			productService.delete(code);
			SearchCondition condition = new SearchCondition();
			Map<String, Object> map = productService.pagingSearch(condition);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);
		}
	}
}
