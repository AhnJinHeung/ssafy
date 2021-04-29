package com.ssafy.web;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}
//  메세지 후킹, 요청 후킹
	class MyRequest extends HttpServletRequestWrapper{

		public MyRequest(HttpServletRequest request) {
			super(request);
			// TODO Auto-generated constructor stub
		}

		@Override
		public String getParameter(String name) {
			if("name".equals(name)) {
				String param = super.getParameter(name);
				if(param == null) {
					return "guest";
				}
			}else if("page".equals(name)) {
				String param = super.getParameter(name);
				if(param == null) {
					return "1";
				}
			}
			return super.getParameter(name);
		}


	}
	class MyResponse extends HttpServletResponseWrapper {
		CharArrayWriter charWriter;

		public MyResponse(HttpServletResponse response) {
			super(response);
			charWriter = new CharArrayWriter();
		}

		@Override
		public PrintWriter getWriter() throws IOException {
			return new PrintWriter(charWriter);
		}

		@Override
		public String toString() {
			return charWriter.toString();
		}
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 사전 처리 영역
		System.out.println("사전처리");
		String naver = request.getParameter("path");
		if("naver".equals(naver)) {
			((HttpServletResponse)response).sendRedirect("http://www.naver.com");
			return;
		}
//		HttpSession session = ((HttpServletRequest)request).getSession();
//		if(session == null) {
//			((HttpServletResponse)response).sendRedirect("/");
//			return;
//		}
		MyRequest mRequest = new MyRequest((HttpServletRequest)request);
		MyResponse responseWrapper = new MyResponse((HttpServletResponse) response);
		responseWrapper.charWriter.append("필터에서 요청처리 전에 추가한 문자열<br>");
		
		chain.doFilter(mRequest, responseWrapper);
		PrintWriter out = response.getWriter();	
		if(response.isCommitted() == false) {
			// 기존 내용
			out.println(responseWrapper.toString());
		}

		out.println("<!--필터에서 요청처리 후에 추가한 문자열 -->");
		out.flush();
		// 사후 처리 영역
		System.out.println("사후처리");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
