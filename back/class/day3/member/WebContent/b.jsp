<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%-- session="true" 디폴트 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	//String key = (String)request.getAttribute("key");
%>
</head>
<body>
보여주는 페이지 <br>
<%= request.getAttribute("key") %> <br>
<%= session.getAttribute("key1") %> <br>
<%= application.getAttribute("key2") %>
</body>
</html>