<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 조회</title>
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
	<h1>상품 목록</h1>
	<table id="product-list">
		<thead>
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>제조회사</th>
				<th>가격</th>
				<th>설명</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productList}" var="product" varStatus="vs">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.company}</td>
					<td>${product.price}</td>
					<td>${product.description}</td>
					<td><a href="${root}/product/update?id=${product.id}">수정</a></td>
					<td><a href="${root}/product/delete?id=${product.id}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="${root}/">메인으로 돌아가기</a>
	<script type="text/javascript">
		let msg = "${msg}";
		if (msg) {
			alert(msg);
		}
	</script>
</body>
</html>