<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
jstl 테스트 <br>
<% 
	String ssafy = "싸피";
	request.setAttribute("ssafy", ssafy);
%>
<c:set var="ssafy" value="싸피" scope="request"/>

ssafy = <c:out value="${ssafy}"/> <%-- <%= ssafy %> --%> <br>
</body>
</html>