<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
String name;
	
public void init() {
	name = "안효인";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY에 오신걸 환영합니다.</title>
</head>
<body>
Hello SSAFY !!!<br>
안녕 싸피 !!!<br>
안녕 <% out.print(name); %> !!!<br>
안녕 <%= name %> !!!<br>
</body>
</html>