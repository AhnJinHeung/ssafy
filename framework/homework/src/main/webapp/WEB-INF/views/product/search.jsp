<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 검색</title>
<style>
#product-list {
	border-collapse: collapse;
	width: 600px;
}

#product-list td, #product-list th {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>상품 검색</h1>
	<div>
		<label for="code">상품 번호 검색</label>
		<form action="${root}/product/select" method="post">
			<input type="text" id="code" name="code">
			<input type="submit" value="검색">
			<input type="reset" value="취소">
		</form>
	</div>
	<c:if test="${empty product}">
		<p>상품이 없습니다.</p>
	</c:if>
	<c:if test="${not empty product}">
	<br>
	<table id="product-list">
		<thead>
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>제조회사</th>
				<th>가격</th>
				<th>설명</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.company}</td>
				<td>${product.price}</td>
				<td>${product.description}</td>
			</tr>
		</tbody>
	</table>
	</c:if>
	<br>
	<a href="${root}/">메인으로 돌아가기</a>
</body>
</html>