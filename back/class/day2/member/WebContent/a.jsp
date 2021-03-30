<%@page import="java.util.Queue"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

id <%= session.getId() %><br>

tomcat  관리 ===> 컨테이너  

서블릿       jsp  공유가 안됨  접근 ... 서블릿. ㅁㅁㅁ()ㅣ   sam.jsp.bb();

A class
	B b = new B();
	b.sss();

B class
세션은 쿠키를 반드시 활용

http 비연결 유지성 통신

<%
	String a = request.getParameter("name");

	Calendar cal = Calendar.getInstance();
	ArrayList list;
	Queue q;
%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>