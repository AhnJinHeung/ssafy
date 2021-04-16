package com.ssafy.backend.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.backend.dto.Book;
import com.ssafy.backend.dto.User;
import com.ssafy.backend.service.BookService;
import com.ssafy.backend.service.BookServiceImpl;
import com.ssafy.backend.service.UserService;
import com.ssafy.backend.service.UserServiceImpl;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("action");
		
		if ("list".equals(act)) {
			getList(request, response);
		} else if("regist".equals(act)) {
			doRegist(request, response);
		} else if ("login".equals(act)) {
			doLogin(request, response);
		} else if ("logout".equals(act)) {
			doLogout(request, response);
		}
	}

	private void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath());
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = UserServiceImpl.getUserService();
		String path = "/index.jsp";
		
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		User user = null;
		
		try {
			user = userService.doLogin(id, pwd);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", user);
			}
			else {
				request.setAttribute("msg", "가입하지 않은 아이디 입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(500);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService = BookServiceImpl.getBookService();
		String path = "/regist_result.jsp";
		
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String desc = request.getParameter("desc");
		String img = request.getParameter("img");
		
		Book book = new Book(isbn, title, author, price, desc, img);
		
		try {
			bookService.doRegist(book);
			request.setAttribute("book", book);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(500);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService = BookServiceImpl.getBookService();
		List<Book> list = null;
		String path = "/list.jsp";
		
		try {
			list = bookService.doList();
			request.setAttribute("bookList", list);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(500);
		}
		
		RequestDispatcher dispater = request.getRequestDispatcher(path);
		dispater.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
