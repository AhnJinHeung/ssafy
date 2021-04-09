package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.model.MemberDto;
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
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnect();
			String sql = "insert into member (userid, username, userpwd, email, address, joindate) \n";
			sql += "values (?, ?, ?, ?, ?, now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserName());
			pstmt.setString(3,  memberDto.getUserPwd());
			pstmt.setString(4, memberDto.getEmail());
			pstmt.setString(5,  memberDto.getAddress());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
	}

	@Override
	public MemberDto login(String userId, String userPwd) {
		MemberDto memberDto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnect();
			String sql = "select userid, username, userpwd, email, address, joindate \n";
			sql += "from member \n";
			sql += "where userid = ? and userpwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  userId);
			pstmt.setString(2, userPwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto = new MemberDto();
				memberDto.setUserId(rs.getString("userid"));
				memberDto.setUserName(rs.getString("username"));
				memberDto.setUserPwd(rs.getString("userpwd"));
				memberDto.setEmail(rs.getString("email"));
				memberDto.setAddress(rs.getString("address"));
				memberDto.setJoindate(rs.getString("joindate"));
				memberDto.setInterest(findInterest(userId));
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
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnect();
			String sql = "update member set userpwd=?, email=?, address=? \n";
			sql += "where userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getUserPwd());
			pstmt.setString(2, memberDto.getEmail());
			pstmt.setString(3, memberDto.getAddress());
			pstmt.setString(4, memberDto.getUserId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
	}

	@Override
	public void deleteMember(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnect();
			String sql = "delete from member where userid = ?\n";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}
	
	public List<String> findInterest(String userid) {
		List<String> list = new ArrayList<String>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnect();
			String sql = "select gugun, dong \n";
			sql += "from interest_area \n";
			sql += "where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list.add(rs.getString("gugun")+rs.getString("dong"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}
	
	public void addInterest(String userid, String gugun, String dong) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnect();
			String sql = "insert into interest_area (userid, gugun, dong) \n";
			sql += "values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, gugun);
			pstmt.setString(3, dong);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
	}
	
	public void removeInterest(String userid, String gugun, String dong) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnect();
			String sql = "delete from interest_area where userid = ? and gugun = ? and dong = ? \n";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, gugun);
			pstmt.setString(3, dong);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}
}
