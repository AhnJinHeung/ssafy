package com.ssafy.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloSsafy.do")
public class HelloSsafy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String name;
	
	public void init() {
		name = "안효인";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("	<title>SSAFY에 오신걸 환영합니다.</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Hello SSAFY!!!<br>");
		out.println("안녕 싸피!!!<br>");
		out.println("안녕 " + name + "!!!");
		out.println("</body>");
		out.println("</html>");
	}

}
