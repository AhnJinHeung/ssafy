<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.member.dto.MemberDto" %>
<%
String root = request.getContextPath();
MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#title {
	margin: 15px auto;
}
a, button {
	margin: 15px;
}
.err {
	font-size: 12px;
	color: red;
	height: 15px;
}
</style>
<script type="text/javascript">
function login() {
	if(document.getElementById("userid").value == "") {
		alert("아이디 입력!!!");
		return;
	} else if(document.getElementById("userpwd").value == "") {
		alert("비밀번호 입력!!!");
		return;
	} else {
		document.getElementById("loginform").action = "<%=root%>/main.do";
		document.getElementById("loginform").submit();
	}
}
</script>
</head>
<body>
<div align="center">
<h1>메인 페이지</h1>
<fieldset style="width: 400px;">
	<div align="center">
		<%
		if (memberDto == null) {
		%>
		<form id="loginform" method="post" action="">
		<div id="title">로그인하여 주세요.</div>
		<table>
			<tr>
				<td>ID</td><td>:</td><td><input type="text" id="userid" name="userid"/></td> 
			</tr>
			<tr>
				<td>PASSWORD</td><td>:</td><td><input type="password" id="userpwd" name="userpwd"/></td>
			</tr>
		</table>
		<input type="hidden" name="act" value="login">
		<div class="err"><%= msg == null ? "" : msg %></div>
		<button type="button" onclick="javascript:login();">로그인</button>
		</form>
		<%
		} else {
		%>
		<%= memberDto.getUserName() %>님 안녕하세요. <br>
		<button type="button" onclick="location.href='<%= root %>/main.do?act=logout'">로그아웃</button>
		<% 
		} 
		%>
	</div>
</fieldset>
<br>
<%
if (memberDto != null) {
%>
<a href="addProduct.jsp">상품 등록</a>
<a href="searchProduct.jsp">상품 검색</a>
<a href="lastProduct.jsp">마지막에 등록한 상품</a>
<a href="<%= root %>/main.do?act=listProduct">상품 목록</a>
<%
}
%>
</div>
</body>
</html>