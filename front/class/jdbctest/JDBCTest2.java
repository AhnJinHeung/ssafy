package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest2 {
	public JDBCTest2() {
//		1. Driver의 대표 클래스 동적 로딩
		try {
			String className = "com.mysql.cj.jdbc.Driver";
			Class.forName(className);
			System.out.println("클래스 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
//		2. 접속 객체 얻어오기
		String jdbcURL = "jdbc:mysql://127.0.0.1:3306/ssafydb?erverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
		String jdbcID = "ssafy";
		String jdbcPW = "1234";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		
		try {
			conn = DriverManager.getConnection(jdbcURL, jdbcID, jdbcPW);
			System.out.println("접속 성공");
			
			// insert
//			SsafyMember member = new SsafyMember();
//			member.setUserid("kimssafy1");
//			member.setUsername("김싸피1");
//			member.setUserpwd("12341");
//			member.setEmailid("kimssafy1");
//			member.setEmaildomain("ssafy.com1");
			
			// statement
//			String sql = "insert into ssafy_member (userid, username, userpwd, emailid, emaildomain, joindate)\r\n" + 
//					"			values ('"+member.getUserid()+"', '"+member.getUsername()+"', '"+member.getUserpwd()+"', '"+member.getEmailid()+"', '"+member.getEmaildomain()+"', now());";
			
			// prepareStatement
//			String sql = "insert into ssafy_member (userid, username, userpwd, emailid, emaildomain, joindate)\r\n" + 
//					"			values (?, ?, ?, ?, ?, now());";
//			
//			3. prepareStatement 객체를 얻는다.
//			stmt = conn.prepareStatement(sql);
			
//			4. 실행
			//	insert, update, delete
//			stmt.setString(1, member.getUserid());
//			stmt.setString(2, member.getUsername());
//			stmt.setString(3, member.getUserpwd());
//			stmt.setString(4, member.getEmailid());
//			stmt.setString(5, member.getEmaildomain());
//			
//			int cnt = stmt.executeUpdate();
//			System.out.println(cnt == 1 ? "성공" : "실패");
			
			// select
			String sql = "select * from ssafy_member where userid like ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%k%");
			rst = stmt.executeQuery();
			
			while (rst.next()) {
				System.out.println(rst.getString(1) + ", " + rst.getString("emaildomain"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rst != null) {
					rst.close();
				}
			}catch(SQLException e) {}
			try {
				if(stmt != null) {
					stmt.close();
				}
			}catch(SQLException e) {}
			try {
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e) {}
		}
	}
	
	public static void main(String[] args) {
		new JDBCTest2();
	}
}
