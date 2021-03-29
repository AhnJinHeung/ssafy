package com.ssafy.life;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle.do")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // servlet 객체는 1개 만들어짐
	
	public LifeCycle() {
		System.out.println("Constructor() Call!!!!!"); // tomcat에 출력 (콘솔창)
	} // 1번 호출

	@Override
	public void init() throws ServletException {
		System.out.println("init() Call!!!!!");
	} // 1번 호출

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() Call!!!!!");
	} // 클라이언트가 호출 될 때마다

	@Override
	public void destroy() {
		System.out.println("destroy() Call!!!!");
	}
}
