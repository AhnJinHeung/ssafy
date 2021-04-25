package com.ssafy.test.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.test.model.dto.Book;
import com.ssafy.test.model.dto.User;
import com.ssafy.test.model.service.BookService;
import com.ssafy.test.model.service.BookServiceImpl;
import com.ssafy.test.model.service.UserService;
import com.ssafy.test.model.service.UserServiceImpl;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainController() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String act = request.getParameter("act");
    	
    	 if ("list".equals(act)) {
    		request.getRequestDispatcher("/list.jsp").forward(request, response);
    	}
    	else if ("registForm".equals(act)) {
    		request.getRequestDispatcher("/regist.jsp").forward(request, response);
    	}
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String act = request.getParameter("act");
		
		if ("login".equals(act)) {
    		login(request, response);
    	}
		else if ("getList".equals(act)) {
			getList(request, response);
		}
		else if ("getBook".equals(act)) {
			getBook(request, response);
		}
		else if ("addBook".equals(act)) {
			addBook(request, response);
		}
		else if ("logout".equals(act)) {
			logout(request, response);
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String path = "index.jsp";
		HttpSession session = request.getSession();
//		session.invalidate();
		session.removeAttribute("loginUser");
//		response.sendRedirect(request.getContextPath());
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "list.jsp";
		String pCode = request.getParameter("pCode");
		List<Book> list = new LinkedList<>();
		
		BookService service = BookServiceImpl.getBookService();
		try {
			Book book = service.select(pCode);
			list.add(book);

			request.setAttribute("bookList", list);
			request.getRequestDispatcher(path).forward(request, response);
		} catch (Exception e) {
			response.sendError(500);
		} 
	}

	private void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String path = "index.jsp";
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String desc = request.getParameter("desc");
		
		Book book = new Book(isbn, title, author, price, desc);
		BookService service = BookServiceImpl.getBookService();
		try {
			service.insert(book);
			request.getRequestDispatcher(path).forward(request, response);
		} catch (Exception e) {
			response.sendError(500);
		}
	}

	private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "list.jsp";
		List<Book> list = null;
		
		BookService service = BookServiceImpl.getBookService();
		try {
			list = service.select();
			request.setAttribute("bookList", list);
			request.getRequestDispatcher(path).forward(request, response);
		} catch (Exception e) {
			response.sendError(500);
		} 
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String path = "index.jsp";
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		User user = null;
		
		UserService service = UserServiceImpl.getUserService();
		
		try {
			user = service.select(id, pass);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", user);
			}
			else {
				request.setAttribute("msg", "id 또는 pass를 확인하세요");
			}
			request.getRequestDispatcher(path).forward(request, response);
		} catch (Exception e) {
			response.sendError(500);
		}
	}
}
