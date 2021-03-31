<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String num = "";
String name = "";
String price = "";
String desc = "";

Cookie cookies[] = request.getCookies();
if (cookies != null) {
	num = cookies[0].getValue();
	name = cookies[1].getValue();
	price = cookies[2].getValue();
	desc = cookies[3].getValue();
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
a {
	margin: 15px;
}
</style>
</head>
<body>
<div align="center">
<h1>마지막에 등록한 상품</h1>
<table>
<tr><th>상품 번호</th><td><%= num %></td>
<tr><th>상 품 명</th><td><%= name %></td>
<tr><th>상품 가격</th><td><%= price %></td>
<tr><th>상품 설명</th><td><%= desc %></td>
</table>
<br>
<a href="">상품 수정</a><a href="">상품 삭제</a><a href="">상품 목록</a>
</div>
</body>
</html>