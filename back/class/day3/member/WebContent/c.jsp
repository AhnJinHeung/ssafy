<%@page import="com.ssafy.member.vo.Product"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 제품정보 <%= ((Product)request.getAttribute("product")).getName() %> <br> --%>
제품명 ${ product.name } <br>
제품코드 ${ product.pCode } <br>
제품정보 ${ product } <br>

addr ${ param.addr } <br>

쿠키 정보 : ${ cookie.JSESSIONID.value } <br>
쿠키 ssafy : ${ cookie.ssafy.value } <br>

3 + 2 = ${3 + 2} <br>
3 > 2 : ${ 3 > 2 } <br>

product 객체 ${ empty product } <br>
korea 객체 ${ empty "korea" } <br>
공백문자열 객체 ${ empty "" } <br>
null 객체 ${ empty null } <br>

<%-- <jsp:param value="" name=""/> JSP 표준액션태그 --%>
</body>
</html>