package com.ssafy.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.model.dto.Product;
import com.ssafy.model.service.ProductService;
import com.ssafy.model.service.ProductServiceImpl;

public class BeanTest {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ssafy/configuration/applicationContext.xml");
		
		ProductService productService = context.getBean("gservice", ProductServiceImpl.class);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Product productDto = new Product();
//		productDto.setName("ssafy");
//		System.out.print("제목 : ");
//		productDto.setSubject(in.readLine());
//		System.out.print("내용 : ");
//		productDto.setContent(in.readLine());
		
//		try {
//			productService.writeArticle(productDto);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		System.out.println("================================== 글목록 ================================== ");
		System.out.println("글번호\t작성자\t작성일\t\t\t제목\t\t\t\t내용");
		System.out.println("----------------------------------------------------------------");
		try {
			List<Product> list = productService.selectAll();
			for(Product p : list) {
				System.out.println(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
