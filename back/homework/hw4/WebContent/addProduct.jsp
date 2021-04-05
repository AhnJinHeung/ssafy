<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String root = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
<div align="center">
	<form method="post" action="<%=root%>/main.do">
		<h1>상품을 등록해 주세요.</h1>
		<table>
			<tr>
				<td>상품 번호</td><td>:</td><td><input type="text" name="num"/></td>
			</tr>
			<tr>
				<td>상 품 명</td><td>:</td><td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>상품 가격</td><td>:</td><td><input type="text" name="price"/></td>
			</tr>
			<tr>
				<td>상품 설명</td><td>:</td><td><input type="text" name="discription"/></td>
			</tr>
		</table> <br>
		<input type="hidden" name="act" value="registerProduct">
		<input type="submit" value="저장"/> 
		<input type="reset" value="취소" onclick="location.href='main.jsp'"/>
	</form>
</div>
</body>
</html>