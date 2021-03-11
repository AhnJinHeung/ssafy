package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {
	public JdbcTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		JdbcTest jdbc = new JdbcTest();
		
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/ssafydb?erverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
			Connection conn = DriverManager.getConnection(url, "ssafy", "1234"); // url, id, pass
			System.out.println("DB 연결 성공 !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
