<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
나는 c.jsp입니다.

cc <%= request.getParameter("cc") %><br>
dd <%= request.getParameter("dd") %><br>
method <%= request.getMethod() %><br>
</body>
</html>