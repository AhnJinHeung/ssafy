<%@page import="com.ssafy.member.dto.ProductDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String root = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: 1px solid black;
}
td {
	width: 150px;
	text-align: center;
}
</style>
</head>
<body>
<div align="center">
<h1>상품 검색</h1>
<form method="get" action="<%=root%>/main.do">
<select name="gubun">
	<option value="searchName">상품명</option>
	<option value="searchPrice">가격</option>
</select>
<input type="hidden" name="act" value="searchProduct">
<input type="text" name="key">
<input type="submit" value="검색">
<input type="button" value="돌아가기" onClick="location.href='main.jsp'">
</form>
<p>
<table>
	<c:if test="${ empty result }">
		목록이 없습니다.
	</c:if>
	<c:if test="${ !empty result }">
		<tr><th>상품 번호</th><th>상 품 명</th><th>상품 가격</th><th>상품 설명</th></tr>
		<c:forEach var="item" items="${ result }">
			<tr><td>${ item.getNum() }</td><td>${ item.getName() }</td><td>${ item.getPrice() }</td><td>${ item.getDiscription() }</td></tr>
		</c:forEach>
	</c:if>
</table>
</div>
</body>
</html>