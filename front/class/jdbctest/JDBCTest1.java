package com.ssafy.jdbc;

public class JDBCTest1 {
	public JDBCTest1() {
//		1. 대표 클래스 동적 로딩한다.
//		com.mysql.cj.jdbc.Driver s = null; // 정적 로딩 - 컴파일 단계에서 검사
		try {
			String className = "com.mysql.cj.jdbc.Driver";
			Class.forName(className); // 동적 로딩 - 실행 단계에서 검사.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new JDBCTest1();
	}
}
