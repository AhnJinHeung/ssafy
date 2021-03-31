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
<title>SSAFY</title>
</head>
<body>
<div align="center">
<%
if (memberDto == null) {
%>
<a href="<%=root%>/main?act=mvregister">회원가입</a>
<a href="<%=root%>/main?act=mvlogin">로그인</a>
<%
} else {
%>
<%= memberDto.getUserName() %>(<%= memberDto.getEmail() %>)님 안녕하세요. <br>
<a href="<%= root %>/main?act=logout">로그아웃</a>
<a href="<%= root %>/user/service.jsp">서비스</a>
<% 
} 
%>
</div>
</body>
</html>