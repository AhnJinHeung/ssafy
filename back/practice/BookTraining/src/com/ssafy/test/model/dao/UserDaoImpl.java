package com.ssafy.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.test.model.dto.User;
import com.ssafy.test.util.DBUtil;

public class UserDaoImpl implements UserDao {
	private static UserDao userDao;
	
	private UserDaoImpl() {}
	
	public static UserDao getUserDao() {
		if (userDao == null) {
			userDao = new UserDaoImpl();
		}
		return userDao;
	}
	
	@Override
	public User select(String id, String pass) throws SQLException {
		User user = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = null;
		DBUtil util = null;
		
		try {
			util = DBUtil.getUtil();
			conn = util.getConnection();
			
			sql = new StringBuilder();
			sql.append("select name from user where id = ? and pass = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(id);
				user.setName(rs.getString("name"));
				user.setPass(pass);
			}
		} finally {
			util.close(conn, pstmt, rs);
		}
		
		return user;
	}

}
