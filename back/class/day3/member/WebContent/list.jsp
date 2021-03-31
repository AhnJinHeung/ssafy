<%@page import="com.ssafy.member.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
목록 보여주기 <br>
<table>
	<c:if test="${ empty list }">
		목록이 없습니다.
	</c:if>
	<c:if test="${ !empty list }">
		<tr><th>이름</th><th>코드명</th><th>가격</th></tr>
		<c:forEach var="p" items="${ list }">
			<tr><td>${ p.name }</td><td>${ p.pCode }</td><td>${ p.price }</td></tr>
		</c:forEach>
	</c:if>
</table>
</body>
</html>