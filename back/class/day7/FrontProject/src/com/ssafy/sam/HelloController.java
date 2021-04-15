package com.ssafy.sam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

	@Override
	public String requestHandle(HttpServletRequest request, 
				HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hello 처리");
		request.setAttribute("result", "ssafy");
//		서비스 
		return "/hello.jsp";
	}

}
