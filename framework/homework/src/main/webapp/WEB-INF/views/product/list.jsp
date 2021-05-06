<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 조회</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
		$(document).ready(function() {
			$(".page-item").click(function() {
				$("#pg").val(($(this).attr("data-page")));
				$("#pageform").attr("action", "${root}/product/search").submit();
			});
		});
</script>
<style>
	#info {
		width:800px;
	}
	label{
		display: inline-block;
		width: 80px;
	}
	textarea {
	width: 100%;
}
</style>
</head>
<body>
	<div class="container">
		<h2><a href="${root}/">상품 목록</a></h2>
		<div>
			<form name="pageform" id="pageform" method="post" action="">
				<input type="hidden" name="pg" id="pg" value="">
				<input type="hidden" name="spp" id="spp" value="10">
				<input type="hidden" name="key" id="key" value="${key}">
				<input type="hidden" name="word" id="word" value="${word}">
			</form>
	
			<form class="form-inline" method="post" action="${root}/product/search">
				<input type="hidden" name="pg" value="1">
				<input type="hidden" name="spp" value="10">
				<div class="form-group md">
					<label for="key">검색 컬럼: </label>
					<select name="key"
						id="key">
						<option value="code">상품번호</option>
						<option value="name">상품명</option>
						<option value="company" selected>제조회사</option>
						<option value="price">가격</option>
					</select>
				</div>
				<div class="form-group md-1">
					<label for="word">검색어: </label>
					<input type="text" name="word" id="sword">
				</div>
				<div style="margin: 5px;">
					<input type="submit" value="검색">
				</div>
			</form>
		</div>
		
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>상품번호</th>
					<th>상품명</th>
					<th>제조회사</th>
					<th>가격</th>
					<th>설명</th>
					<th>파일</th>
					<th>파일명</th>
					<th>byte</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productList}" var="product" varStatus="vs">
					<tr>
						<td>${product.code}</td>
						<td>${product.name}</td>
						<td>${product.company}</td>
						<td>${product.price}</td>
						<td>${product.description}</td>
						<td>${product.file}</td>
						<td>${product.fileName}</td>
						<td>${product.fileSize}</td>
						<td><a href="${root}/product/update?code=${product.code}">수정</a></td>
						<td><a href="${root}/product/delete?code=${product.code}">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<%@ include file="/WEB-INF/views/include/paging.jsp"%>
	
	<script type="text/javascript">
		let msg = "${msg}";
		if (msg) {
			alert(msg);
		}
	</script>
</body>
</html>