package com.ssafy.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloSsafy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); // 나는 text로 보낼거지만 브라우저에서는 html로 인식해
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("		Hello SSAFY !!!");	
		out.println("		안녕 싸피 !!!");
		out.println("	</body>");	
		out.println("</html>");	
	}
}

/*
	web page 이동
	
	GET
	1. url 직접 입력
	2. link
	3. form
	
	--------------
	POST
	
	servlet : java 안에 html을 포함
	jsp : html 안에 java를 포함
*/