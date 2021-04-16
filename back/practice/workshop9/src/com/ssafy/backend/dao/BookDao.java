package com.ssafy.backend.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.backend.dto.Book;

public interface BookDao {
	public void doRegist(Book book) throws SQLException;
	
	public List<Book> doList() throws SQLException;
}
