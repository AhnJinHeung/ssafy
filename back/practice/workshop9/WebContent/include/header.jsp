<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- User를 사용하기 위해 dto 패키지를 import 한다. --%>
<%@ page import="com.ssafy.backend.dto.*"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#title {
	text-align: center;
}

#user-info {
	text-align: right;
}
</style>
<h1 id="title"><a href="index.jsp">SSAFY 도서 관리</a></h1>
<div id="user-info">
	<%-- session에서 loginUser를 가져와서 존재 여부에 따라 로그인 폼 또는 사용자 정보를 출력한다. --%>
	<%--로그인 정보가 없을 경우는 로그인을 위한 폼을 제공한다. --%>
	<c:if test="${userinfo eq null}">
		<form method="post" action="main">
			<div><input type="hidden" name="action" value="login"></div>
			<div><input type="text" name="userId"></div>
			<div><input type="password" name="userPwd"></div>
			<div><input type="submit" value="로그인"></div>
		</form>
	</c:if>
	<%--로그인 정보가 있는 경우는 사용자 이름과 로그아웃을 위한 링크를 생성한다.--%>
	<c:if test="${userinfo ne null}">
		<a href="#">${userinfo.name}</a>
		<a href="main?action=logout">로그아웃</a>
	</c:if>
</div>
<hr>
<script>
	// request 영역에 msg라는 이름의 attribute가 있다면 화면에 alert으로 출력한다.
	let msg = "${msg}";
	if (msg) {
		alert(msg);
	}
</script>