package com.ssafy.member.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.member.vo.Product;

@WebServlet("/c.do")
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Product product = new Product(); // DB에서 읽어온 내용
		product.setName("노트북");
		product.setpCode("notebook");
		product.setPrice(2000);
		
		Product product1 = new Product(); // DB에서 읽어온 내용
		product1.setName("노트북1");
		product1.setpCode("notebook1");
		product1.setPrice(20001);
		
//		request.setAttribute("product", product);
		
		HttpSession session = request.getSession();
		session.setAttribute("product", product1);
		
		Cookie cookie = new Cookie("ssafy", "테스트"); // hard 영구보관
		cookie.setMaxAge(10000);
		cookie.setPath("/");
		response.addCookie(cookie); // 필수 !
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("c.jsp");
		dispatcher.forward(request, response);
		
		// 아래에는 명령어 출력이 없어야 한다.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
