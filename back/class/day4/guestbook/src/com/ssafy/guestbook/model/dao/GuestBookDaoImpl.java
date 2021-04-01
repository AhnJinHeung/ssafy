package com.ssafy.guestbook.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.util.DBUtil;

public class GuestBookDaoImpl implements GuestBookDao {

	private static GuestBookDao guestBookDao;
	
	private GuestBookDaoImpl() {};
	
	public static GuestBookDao getGuestBookDao() {
		if (guestBookDao == null) {
			guestBookDao = new GuestBookDaoImpl();
		}
		return guestBookDao;
	}
	
	@Override
	public void registerArticle(GuestBookDto guestBookDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBUtil.getConnect();
			StringBuilder insertMember = new StringBuilder();
			insertMember.append("insert into guestbook (userid, subject, content, regtime) \n");
			insertMember.append("values (?, ?, ?, now())");
			pstmt = conn.prepareStatement(insertMember.toString());
			pstmt.setString(1, guestBookDto.getUserId());
			pstmt.setString(2, guestBookDto.getSubject());
			pstmt.setString(3, guestBookDto.getContent());
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
	}

	@Override
	public List<GuestBookDto> listArticle(String key, String word) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GuestBookDto getArticle(int articleNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyArticle(GuestBookDto guestBookDto) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteArticle(int articleNo) throws SQLException {
		// TODO Auto-generated method stub

	}

}
