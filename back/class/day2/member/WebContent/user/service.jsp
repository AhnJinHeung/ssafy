<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.member.dto.MemberDto" %>
<%
String root = request.getContextPath();
MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if (memberDto != null) { // 로그인 중.
%>
로그인시 일시적인 서비스...
<%	
} else { // 로그인 x
	response.sendRedirect(request.getContextPath()+"/user/login.jsp");
}
%>
</body>
</html>