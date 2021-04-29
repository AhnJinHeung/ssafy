package com.ssafy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.model.dto.Product;
import com.ssafy.model.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/selectAll", method=RequestMethod.GET)
	public String selectAll(Model model) {
		List<Product> list = null;
		try {
			list = productService.selectAll();
			model.addAttribute("productList", list);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "전체 목록 조회 중 오류 발생");
			return "error/error";
		}
		return "product/list";
	}
	
	@RequestMapping(value="/select", method=RequestMethod.GET)
	public String search() {
		return "product/search";
	}
	
	@RequestMapping(value="/select", method=RequestMethod.POST)
	public String select(@RequestParam("code") String id, Model model) {
		Product product = null;
		try {
			product = productService.select(id);
			model.addAttribute("product", product);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "상품 조회 중 오류 발생");
			return "error/error";
		}
		return "product/search";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		return "product/regist";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(Product product, Model model) {
		try {
			productService.insert(product);
			model.addAttribute("msg", "상품이 등록 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "상품 등록 중 오류 발생");
			return "error/error";
		}
		return "index";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(String id, Model model) {
		Product product = null;
		try {
			product = productService.select(id);
			model.addAttribute("product", product);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "상품 조회 중 오류 발생");
			return "error/error";
		}
		return "product/update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(Product product, Model model) {
		try {
			productService.update(product);
			model.addAttribute("product", product);
			model.addAttribute("msg", "업데이트 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "상품 수정 중 오류 발생");
			return "error/error";
		}
		return "product/update";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(String id, Model model) {
		try {
			productService.delete(id);
			model.addAttribute("msg", "삭제 되었습니다.");
			selectAll(model);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "상품 삭제 중 오류 발생");
			return "error/error";
		}
		return "index";
	}
}
