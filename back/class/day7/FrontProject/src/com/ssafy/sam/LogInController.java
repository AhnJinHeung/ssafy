package com.ssafy.sam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInController implements Controller {

	@Override
	public String requestHandle(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		// 로그인 업무
//		서비스 호출 //post 방식 호출
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String hd = request.getHeader("aid");		
		System.out.println("로그인 처리" + id + ", " + pw + "aid : " + hd);
		return "/index.jsp";
	}

}
