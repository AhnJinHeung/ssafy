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
  //<h1> DB데이터를 불러와서 JSON형태로 변경 출력 </h1>
    // 1. 드라이버로드
     String DRIVER = "com.mysql.jdbc.Driver";
     String DBURL = "jdbc:mysql://127.0.0.1:3306/happyhouse"; //사용할DB이름
     String DBID = "ssafy";
     String DBPW = "ssafy";
    
     JSONArray arr = null;
     
     try {
        //2. DB연결
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);
        //3.sql & pstmt
            String sql = "select gugun_name from guguncode";
            PreparedStatement pstmt = con.prepareStatement(sql);    
        //4.실행
		
	//4.실행
		ResultSet rs = pstmt.executeQuery();
		//5.
		//기존방식: 행 1줄을 자바빈객체에 저장해서 ArrayList 한 칸에 저장
		//json이용한 방식: 행 1줄을 jsonObject객체에 저장해서 JsonArray 한 칸에 저장
		
		//5-2.JSONArray 생성
		arr = new JSONArray();
		
		//5-1.while문
		while(rs.next()){
			//json object 생성 (import json-simple패키지해야함)
			JSONObject obj = new JSONObject();
			obj.put("gugun_name", rs.getString("gugun_name"));
			
			//5-3.배열한칸에 객체 하나를 저장
			arr.add(obj);
		}
		}catch(SQLException e){
			e.printStackTrace();
		}


  %>

<%=arr%>