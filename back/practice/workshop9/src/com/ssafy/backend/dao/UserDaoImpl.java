package com.ssafy.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.backend.dto.User;
import com.ssafy.util.DBUtil;

public class UserDaoImpl implements UserDao {
	private static UserDao userDao;
	
	private UserDaoImpl() {}
	
	public static UserDao getUserService() {
		if (userDao == null) 
			userDao = new UserDaoImpl();
		return userDao;
	}

	@Override
	public User doLogin(String id, String pwd) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select name, rec_id from user where id = ? and pass = ?";
		
		User user = null;
		
		try {
			conn = DBUtil.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				user = new User();
				user.setId(id);
				user.setPass(pwd);
				user.setName(rs.getString("name"));
				user.setRec_id(rs.getString("rec_id"));
			}
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		
		return user;
	}
}
