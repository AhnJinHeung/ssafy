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
	<c:if test="${ !empty param.tel }">
	파라미터가 넘어온 경우
	tel : ${ param.tel } <br>
	<%@ include file="in.jsp" %>
	</c:if>
	<c:if test="${ empty param.tel }">
	그렇지 않은 경우
	</c:if>
</body>
</html>