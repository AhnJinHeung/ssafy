package com.ssafy.interceptor;

import javax.servlet.http.*;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssafy.guestbook.model.MemberDto;

public class ConfirmInterceptor extends HandlerInterceptorAdapter {
	/////로그인 안한사람은 이용못하는 페이지들로 접근할 때 여기서 처리됨.(이거 밑에쓰고 servlet-context.xml에서 설정 또 해줘야함.)
	////  servlet-context.xml 30번째 줄 확인하기
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if(memberDto == null) {
			response.sendRedirect(request.getContextPath());
			return false;
		}
		return true;
	}

	
	
}
