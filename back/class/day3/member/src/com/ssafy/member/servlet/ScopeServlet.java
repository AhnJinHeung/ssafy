package com.ssafy.member.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/path.do") // URL 매핑, URL 라우팅
//@WebServlet(urlPatterns = {"/path.do", "/a.do", "/b.do"})
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ScopeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		application.setAttribute("key2", "backend");
		
//		HttpSession session = request.getSession();
//		session.setAttribute("key1", "java");
		
//		request.setAttribute("key", "ssafy");
		
		// session은 동일한 브라우저 내, application은 다른 브라우저에서도 가능
		response.sendRedirect("b.jsp"); // request일 때 이거는 null이 나옴, session일 때는 값 나옴
		
//		RequestDispatcher dispathcher = request.getRequestDispatcher("b.jsp");
//		dispathcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
