<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<%
String num = "";
String name = "";
String price = "";
String discription = "";

Cookie cookies[] = request.getCookies();
if (cookies != null) {
	num = cookies[0].getValue();
	name = cookies[1].getValue();
	name = URLDecoder.decode(name, "utf-8");
	price = cookies[2].getValue();
	discription = cookies[3].getValue();
	discription = URLDecoder.decode(discription, "utf-8");
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
table {
	padding: 5px;
	border: 1px solid black;
}
td, th {
	width: 150px;
	text-align: center;
}
</style>
<script>
	function modifyProduct(){
		alert("상품 정보가 수정되었습니다.");
		
		document.getElementById("modifyForm").action = "${root}/main.do";
		document.getElementById("modifyForm").submit();
	}
</script>
</head>
<body>
<div align="center">
<h1>마지막에 등록한 상품</h1>
<form method="post" id="modifyForm">
<table>
<tr><th>상품 번호</th><td><input type="text" name="num" value="<%= num %>" readOnly></td>
<tr><th>상 품 명</th><td><input type="text" name="name" value="<%= name %>" readOnly></td>
<tr><th>상품 가격</th><td><input type="text" name="price" value="<%= price %>"></td>
<tr><th>상품 설명</th><td><input type="text" name="discription" value="<%= discription %>"></td>
</table>
<br>
<input type="hidden" name="act" value="modifyProduct">
<input type="button" value="상품 수정" onClick="javascript:modifyProduct();">
<input type="button" value="돌아가기" onClick="location.href='main.jsp'">
</form>
<br>
</div>
</body>
</html>