<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>parameter전달.</title>
</head>
<body>
<div align="center">
<%
String userId = request.getParameter("userid");
String userName = request.getParameter("username");
int area = Integer.parseInt(request.getParameter("area"));

String color[] = {"steelblue", "orange", "tomato", "green"};
%>
<%= userName %>(<font color="<%= color[area] %>"><%= userId %></font>)님 안녕하세요!!!
</div>
</body>
</html>