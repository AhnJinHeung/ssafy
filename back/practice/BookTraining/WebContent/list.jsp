<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
	<div>
		<form action="${root}/main" method="post">
			<input type="hidden" name="act" value="getBook">
			<input type="text" name="pCode" placeholder="도서 번호 검색">
			<input type="submit" value="검색">
		</form>
		<form action="${root}/main" method="post">
			<input type="hidden" name="act" value="getList">
			<input type="submit" value="전체 목록 검색">
		</form>
	</div>
	<h2>도서 목록</h2>
	<table>
		<thead>
			<tr>
				<th>isbn</th><th>title</th><th>author</th><th>price</th><th>desc</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${bookList}">
				<tr>
				<td>${list.isbn}</td>
				<td>${list.title}</td>
				<td>${list.author}</td>
				<td>${list.price}</td>
				<td>${list.desc}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>