package com.ssafy.sam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		boardWrite.do // 글씨기 작업
//		meberInsert.do // 회원가입
//		login.do // 로그인 처리
//		main.do?act=login
//		http://localhost:8080/ssafy/aaa/bbb/ccc/board.do?aaa=bbb&ccc=ddd
		
		String uri = request.getRequestURI();
//		String url = request.getRequestURL().toString();
//		String queryString = request.getQueryString();
//		http://localhost:8080/ssafy/aaa/bbb/ccc/hello.do?aaa=bbb&ccc=ddd
		String path = uri.substring(uri.lastIndexOf("/"));
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("path : " + path);
//		새로운 업무 로그인 업무
		Controller controller = HandlerMapping.getMapping(path);
		String returnURL = controller.requestHandle(request, response);
		
		request.getRequestDispatcher(returnURL).forward(request, response);;
		
//		switch(path) {
//		case "/login.do":
//			doAction();
//			break;
//		}
//		System.out.println("url : " + url);
//		System.out.println("queryString : " + queryString);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
