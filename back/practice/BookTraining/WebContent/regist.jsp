<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#registForm label {
	display: inline-block;
	width: 100px;
}
</style>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<h2>도서 등록</h2>
	<form method="post" action="${root }/main" id="registForm">
		<input type="hidden" name="act" value="addBook">
		<div><label for="isbn">번호:</label><input type="text" name="isbn" id="isbn"></div>
		<div><label for="Btitle">제목:</label><input type="text" name="title" id="Btitle"></div>
		<div><label for="author">작가:</label><input type="text" name="author" id="author"></div>
		<div><label for="price">가격:</label><input type="text" name="price" id="price"></div>
		<div><label for="desc">설명:</label><input type="text" name="desc" id="desc"></div>
		<div><input type="submit" value="도서 등록"></div>
	</form>
</body>
</html>
