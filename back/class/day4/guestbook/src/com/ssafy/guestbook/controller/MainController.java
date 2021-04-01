package com.ssafy.guestbook.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.service.GuestBookServiceImpl;
import com.ssafy.guestbook.model.service.MemberServiceImpl;


@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");
		
		if ("mvregister".equals(act)) {
			response.sendRedirect(root+"/user/join.jsp");
		} else if ("login".equals(act)) {
			login(request, response);
		} else if ("logout".equals(act)) {
			logout(request, response);
		} else if ("mvwrite".equals(act)) {
			response.sendRedirect(root+"/guestbook/write.jsp");
		} else if ("write".equals(act)) {
			registerArticle(request, response);
		} else if ("".equals(act)) {
			
		}
	}

	private void registerArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		
		if (memberDto != null) {
			GuestBookDto guestBookDto = new GuestBookDto();
			guestBookDto.setUserId(memberDto.getUserId());
			guestBookDto.setSubject(request.getParameter("subject"));
			guestBookDto.setContent(request.getParameter("content"));
			
			try {
				GuestBookServiceImpl.getGuestBookService().registerArticle(guestBookDto);
				path = "/guestbook/writesuccess.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글 작성 중 문제가 발생했습니다.");
				path = "/error/error500.jsp";
			}
		}
		else {
			request.setAttribute("msg", "로그인 후 사용가능한 서비스입니다.");
			path = "/error/error500.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect(request.getContextPath());
	}

	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");
		
		MemberDto memberDto = MemberServiceImpl.getMemberService().login(userId, userPwd);
		
		String path = "/index.jsp";
		if (memberDto != null) { // 성공
//			session 설정
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", memberDto);
			
//			Cookie 설정
			String idsv = request.getParameter("idsave");
			if ("saveok".equals(idsv)) { // 아이디 저장 o
				Cookie cookie = new Cookie("save_id", userId);
				cookie.setPath(request.getContextPath()); // 로컬호스트에서 member에서 쓸 것임
				cookie.setMaxAge(60 * 60 * 24 * 365 * 40);
				
				response.addCookie(cookie); // 쿠키 응답페이지에 추가
			}
			else { // 아이디 저장 x
				Cookie cookies[] = request.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("save_id")) {
							cookie.setMaxAge(0);
							response.addCookie(cookie); // 쿠키 응답페이지에 추가
							break;
						}
					}
				}
			}
			
		}
		else { // 실패
			request.setAttribute("msg", "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
			path = "/error/error500.jsp";
		}
		
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}

}
