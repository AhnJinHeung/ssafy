<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%
     String DRIVER = "com.mysql.jdbc.Driver";
     String DBURL = "jdbc:mysql://127.0.0.1:3306/happyhouse"; //사용할DB이름
     String DBID = "ssafy";
     String DBPW = "ssafy";
    
     JSONArray arr = null;
     
     try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);
            String sql = "select dong from dongcode";
        
            PreparedStatement pstmt = con.prepareStatement(sql);    
		
		ResultSet rs = pstmt.executeQuery();
		
		arr = new JSONArray();
		
		while(rs.next()){
			JSONObject obj = new JSONObject();
			obj.put("dong_name", rs.getString("dong"));
			
			arr.add(obj);
		}
		}catch(SQLException e){
			e.printStackTrace();
		}


  %>

<%=arr%>