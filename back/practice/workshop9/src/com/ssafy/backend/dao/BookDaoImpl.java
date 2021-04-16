package com.ssafy.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.backend.dto.Book;
import com.ssafy.util.DBUtil;

public class BookDaoImpl implements BookDao {
	private static BookDao bookDao;
	
	private BookDaoImpl() {}
	
	public static BookDao getBookService() {
		if (bookDao == null) 
			bookDao = new BookDaoImpl();
		return bookDao;
	}
	
	@Override
	public void doRegist(Book book) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into book values(?, ?, ?, ?, ?, ?)";
				
		try {
			conn = DBUtil.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setInt(4, book.getPrice());
			pstmt.setString(5, book.getDesc());
			pstmt.setString(6, book.getImg());
			
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(conn, pstmt);
		}
	}

	@Override
	public List<Book> doList() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Book> list = new ArrayList<Book>();
		
		String sql = "select isbn, title, author, price, `desc`, img from book";
		
		try {
			conn = DBUtil.getConnect();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Book book = new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("desc"));
				book.setPrice(rs.getInt("price"));
				book.setDesc(rs.getString("desc"));
				book.setImg(rs.getString("img"));
				
				list.add(book);
			}
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	
}
