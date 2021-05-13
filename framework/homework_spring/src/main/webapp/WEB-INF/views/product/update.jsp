<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 수정</title>
<style>
	#info {
		width:600px;
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
	<h1>상품 정보 수정</h1>
	<form method="post" action="${root}/product/update" enctype="multipart/form-data">
		<fieldset id="info">
		<legend>상품 정보</legend>
		<label for="code">상품번호</label>
		<input type="text" id="code" name="code" value="${product.code}" readonly="readonly"><br>
		<label for="name">상품명</label>
		<input type="text" id="name" name="name" value="${product.name}"><br>
		<label for="company">제조회사</label>
		<input type="text" id="company" name="company" value="${product.company}"><br>
		<label for="price">가격</label>
		<input type="number" id="price" name="price" value="${product.price}"><br>
		<label for="desc">설명</label>
		<br>
		<textarea id="description" name="description">${product.description}</textarea><br>
		<label for="attach">첨부파일</label><input type="file" id="attach" name="attach"><p>
		<div>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
		</div>
		</fieldset>
	</form>
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