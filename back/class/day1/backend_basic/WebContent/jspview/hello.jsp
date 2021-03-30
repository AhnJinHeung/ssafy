<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" info="이 파일은 간단한 예제입니다."
    import="java.util.Date"%>
<%--
속성 간의 공백 주의
session의 default는 true
--%>
<%!
String name;
	
public void init() {
	name = "안효인";
}
%>
<%
DateFormat df = new SimpleDateFormat("HH:mm:ss");
Date date = new Date();
String time = df.format(date);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY에 오신걸 환영합니다.</title>
</head>
<body>
Hello SSAFY !!!<br>
안녕 싸피 !!!<br>
안녕 <% out.print(name); %> !!!<br>
안녕 <%= name %> !!!<br>
시간 : <%= time %>
</body>
</html>