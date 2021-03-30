<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<%!
public void init() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
%>
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String subject = request.getParameter("subject");
String content = request.getParameter("content");

//2. logic
Connection conn = null;
PreparedStatement pstmt = null;
int cnt = 0;
try {
	conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy", "1234");
	StringBuilder insertMember = new StringBuilder();
	insertMember.append("insert into guestbook (username, subject, content, regtime) \n");
	insertMember.append("values (?, ?, ?, now())");
	pstmt = conn.prepareStatement(insertMember.toString());
	pstmt.setString(1, name);
	pstmt.setString(2, subject);
	pstmt.setString(3, content);
	cnt = pstmt.executeUpdate();
} catch (SQLException e) {
	e.printStackTrace();
} finally {
	try {
		if(pstmt != null)
			pstmt.close();
		if(conn != null)
			conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

if(cnt != 0) {
	response.sendRedirect(request.getContextPath() + "/guestbook/writesuccess.jsp");
} else {
	response.sendRedirect(request.getContextPath() + "/guestbook/writefail.jsp");
}
%>
