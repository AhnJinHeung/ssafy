package com.ssafy.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.test.model.dto.Book;
import com.ssafy.test.util.DBUtil;

public class BookDaoImpl implements BookDao {
	private static BookDao bookDao;
	
	private BookDaoImpl() {}
	
	public static BookDao getBookDao() {
		if (bookDao == null) {
			bookDao = new BookDaoImpl();
		}
		return bookDao;
	}
	
	@Override
	public void insert(Book product) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = null;
		DBUtil util = null;
				
		try {
			util = DBUtil.getUtil();
			conn = util.getConnection();
			
			sql = new StringBuilder();
			sql.append("insert into book values(?, ?, ?, ?, ?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, product.getIsbn());
			pstmt.setString(2, product.getTitle());
			pstmt.setString(3, product.getAuthor());
			pstmt.setInt(4, product.getPrice());
			pstmt.setString(5, product.getDesc());
			
			pstmt.executeUpdate();
		} finally {
			util.close(conn, pstmt);
		}
	}

	@Override
	public Book select(String pCode) throws SQLException {
		Book book = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = null;
		DBUtil util = null;
		
		try {
			util = DBUtil.getUtil();
			conn = util.getConnection();

			sql = new StringBuilder();
			sql.append("select title, author, price, `desc` from book where isbn = ?");
					
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, pCode);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new Book();
				book.setIsbn(pCode);
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				book.setDesc(rs.getString("desc"));
			}
		} finally {
			util.close(conn, pstmt, rs);
		}
		return book;
	}

	@Override
	public List<Book> select() throws SQLException {
		List<Book> list = new LinkedList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = null;
		DBUtil util = null;
		
		try {
			util = DBUtil.getUtil();
			conn = util.getConnection();

			sql = new StringBuilder();
			sql.append("select isbn, title, author, price, `desc` from book");
			
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Book book = new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
				book.setDesc(rs.getString("desc"));
				list.add(book);
			}
		} finally {
			util.close(conn, pstmt, rs);
		}
		
		return list;
	}

}
