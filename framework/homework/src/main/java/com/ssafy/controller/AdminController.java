package com.ssafy.controller;

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

import com.ssafy.model.dto.Product;
import com.ssafy.model.dto.SearchCondition;
import com.ssafy.model.service.ProductService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private ProductService productService;
	
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
