<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!-- DTO를 참조하기 위해서 import 처리가 필요하다. -->
<%@ page import="com.ssafy.backend.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록 결과</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
}

th:nth-child(1) {
	width: 100px;
}
</style>
</head>
<body>
	<h1>도서 등록 결과</h1>
	<%-- JSP에서 자바 코드를 사용하기 위해 script-let을 사용한다. --%>
	<%
	// request 영역에 book이라는 이름으로 등록된 자료를 가져온다.
	// request 영역에 접근하기 위해 request 내장 객체를 활용한다.
	Object bookObj = request.getAttribute("book");
	// 만약 bookObj가 설정된 상태라면 Book 형태로 형변환 후 사용한다.
	if (bookObj != null) {
	    Book book = (Book) bookObj;
	%>
	<h2>등록 도서 정보</h2>
	<%-- 테이블 내에서 book의 내용을 출력하기 위해 expression tag를 사용한다. --%>
	<table>
		<thead>
			<tr>
				<th>항목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>도서번호</td>
				<td><%=book.getIsbn()%></td>
			</tr>
			<tr>
				<td>도서명</td>
				<td><%=book.getTitle()%></td>
			</tr>
			<tr>
				<td>저자</td>
				<td><%=book.getAuthor()%></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><%=book.getPrice()%></td>
			</tr>
			<tr>
				<td>설명</td>
				<td><%=book.getDesc()%></td>
			</tr>
		</tbody>
	</table>
	<%
	    }
	// 만약 bookObj가 설정된 상태라면 Book 형태로 형변환 후 사용한다.
	else {
	%>
	<p>등록된 도서가 없습니다.</p>
	<%
	    }
	%>
	<!-- 다시 도서를 등록할 수 있는 링크를 제공한다. -->
	<a href="regist.html">추가등록</a>
</body>
</html>