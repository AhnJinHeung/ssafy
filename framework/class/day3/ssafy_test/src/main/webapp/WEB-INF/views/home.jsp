<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=utf-8" %>
<%
	System.out.println("jsp 안쪽");
%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  한글
	
</h1>
받은 정보 name :  ${param.name }<br>
받은 정보 tel : ${param.tel }<br>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
