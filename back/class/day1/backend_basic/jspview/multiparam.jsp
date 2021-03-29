<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>같은 이름의 여러개 parameter전달.</title>
</head>
<body>
<div align="center">
<%
request.setCharacterEncoding("utf-8");
String userId = request.getParameter("userid");
String userName = request.getParameter("username");
String fruits[] = request.getParameterValues("fruit");

StringBuilder sb = new StringBuilder();
if(fruits != null) {
	int len = fruits.length;
	for(int i=0;i<len;i++) {
		sb.append(fruits[i]);
		if(i != len - 1)
			sb.append(", ");
	}
	sb.append("입니다.");
} else {
	sb.append("없습니다.");
}
%>
<%= userName %>(<strong><%= userId %></strong>)님이 좋아하는 과일은 <%= sb.toString() %>
</div>
</body>
</html>