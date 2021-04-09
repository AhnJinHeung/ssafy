package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.ssafy.happyhouse.model.AddressDto;
import com.ssafy.happyhouse.model.HouseDto;
import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.service.AddressServiceImpl;
import com.ssafy.happyhouse.model.service.HouseService;
import com.ssafy.happyhouse.model.service.HouseServiceImpl;
import com.ssafy.happyhouse.model.service.MemberServiceImpl;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");

		if ("mvregister".equals(act)) {
			response.sendRedirect(root + "/signUp.jsp");
		} else if ("login".equals(act)) {
			login(request, response);
		} else if ("logout".equals(act)) {
			logout(request, response);
		} else if ("register".equals(act)) {
			register(request, response);
		} else if ("findApt".equals(act)) {
			findApt(request, response);
		} else if ("deleteMember".equals(act)) {
			deleteMember(request, response);
		} else if ("modify".equals(act)) {
			modify(request, response);
		} else if ("gugunsearch".equals(act)) {
			gugunsearch(request, response);
		}else if ("dongsearch".equals(act)) {
			dongsearch(request, response);
		}else if ("addInterest".equals(act)) {
			addInterest(request, response);
		}else if ("removeInterest".equals(act)) {
			removeInterest(request, response);
		}
	}
	
	private void removeInterest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		MemberDto dto = (MemberDto) session.getAttribute("userinfo");
		
		String userid = dto.getUserId();
		String dong = request.getParameter("dong");
		String gugun = request.getParameter("gugun");
		
		List<String> list = dto.getInterest();
		list.remove(gugun+dong);
		dto.setInterest(list);
		
		MemberServiceImpl.getMemberService().removeInterest(userid, gugun, dong);
		
		findApt(request, response);
	}

	private void addInterest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		MemberDto dto = (MemberDto) session.getAttribute("userinfo");
		
		String userid = dto.getUserId();
		String dong = request.getParameter("dong");
		String gugun = request.getParameter("gugun");
		
		List<String> list = dto.getInterest();
		list.add(gugun+dong);
		dto.setInterest(list);
		
		MemberServiceImpl.getMemberService().addInterest(userid, gugun, dong);
		
		findApt(request, response);
	}

	private void dongsearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String gugun = request.getParameter("gugun");
		List<AddressDto> donglist = null;
	    PrintWriter out;
		try {
			donglist = AddressServiceImpl.getAddressService().searchDong(gugun);
			Gson gson = new Gson();
			String result = gson.toJson(donglist);
			response.setContentType("application/json; charset=utf8");
            out = response.getWriter(); //response해쥼
            out.println(result);
            out.flush();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	private void gugunsearch(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String si = request.getParameter("sido");
		List<AddressDto> gugunlist = null;
	    PrintWriter out;
		try {
			gugunlist = AddressServiceImpl.getAddressService().searchGugun(si);
			Gson gson = new Gson();
			String result = gson.toJson(gugunlist);
//			request.setAttribute("result", result);
			response.setContentType("application/json; charset=utf8");
			out = response.getWriter(); //response해쥼
			out.println(result);
			out.flush();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
//		RequestDispatcher dis = request.getRequestDispatcher("result.jsp");
//		dis.forward(request, response);
	}

	private void modify(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userId = request.getParameter("info_id");
		String userPwd = request.getParameter("info_pwd");
		String address = request.getParameter("info_address");
		String email = request.getParameter("info_email");
		String userName = request.getParameter("info_name");
		String joindate = request.getParameter("info_date");

		MemberDto memberDto = new MemberDto();
		memberDto.setUserId(userId);
		memberDto.setUserPwd(userPwd);
		memberDto.setEmail(email);
		memberDto.setAddress(address);
		memberDto.setUserName(userName);
		memberDto.setJoindate(joindate);

		MemberServiceImpl.getMemberService().modifyMember(memberDto);

		HttpSession session = request.getSession();
		session.setAttribute("userinfo", memberDto);

		response.sendRedirect(request.getContextPath());
	}

	private void deleteMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto dto = (MemberDto) session.getAttribute("userinfo");

		if (dto != null) {
			MemberServiceImpl.getMemberService().deleteMember(dto.getUserId());
			session.invalidate();
		}
		String path = "index.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}

	private void findApt(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String gugun = request.getParameter("gugun");
		String dong = request.getParameter("dong");
		request.setAttribute("dong", dong);
		request.setAttribute("gugun", gugun);
		String path = "tradeApt.jsp";
//		로직처리
		HouseService service = HouseServiceImpl.gethouseService();
		List<HouseDto> list = null;
		try {
			list = service.findApt(dong);
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "거래 내역을 불러오는데 실패했습니다.");
		}

//		보여질 페이지로 이동
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");
		String userName = request.getParameter("username");
		String address = request.getParameter("address");
		String email = request.getParameter("email");

		MemberDto memberDto = new MemberDto(userId, userName, userPwd, email, address, null);

		MemberServiceImpl.getMemberService().registerMember(memberDto);

		response.sendRedirect(request.getContextPath());
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();

		response.sendRedirect(request.getContextPath());
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");

		MemberDto memberDto = MemberServiceImpl.getMemberService().login(userId, userPwd);

		String path = "/index.jsp";
		if (memberDto != null) { // 성공
//         session 설정
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", memberDto);

//         Cookie 설정
			String idsv = request.getParameter("idsave");
			if ("saveok".equals(idsv)) { // 아이디 저장 o
				Cookie cookie = new Cookie("save_id", userId);
				cookie.setPath(request.getContextPath()); // 로컬호스트에서 member에서 쓸 것임
				cookie.setMaxAge(60 * 60 * 24 * 365 * 40);

				response.addCookie(cookie); // 쿠키 응답페이지에 추가
			} else { // 아이디 저장 x
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

		} else { // 실패
			request.setAttribute("msg", "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
			path = "/index.jsp";
		}

		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}

}