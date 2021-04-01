package com.ssafy.guestbook.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	
	private static MemberDao memberDao;
	
	private MemberDaoImpl() {}
	
	public static MemberDao getMemberDao() {
		if (memberDao == null) {
			memberDao = new MemberDaoImpl();
		}
		return memberDao;
	}
	
	@Override
	public void registerMember(MemberDto memberDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public MemberDto login(String userId, String userPwd) {
		MemberDto memberDto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnect();
//			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy", "1234");
			String sql = "select username, email \n";
			sql += "from ssafy_member \n";
			sql += "where userid = ? and userpwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  userId);
			pstmt.setString(2, userPwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserName(rs.getString("username"));
				memberDto.setUserId(userId);
				memberDto.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return memberDto;
	}

	@Override
	public MemberDto getMember(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyMember(MemberDto memberDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMember(String userId) {
		// TODO Auto-generated method stub

	}

}
