package com.ssafy.test.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.test.model.dto.Book;

public interface BookService {
	void insert(Book product) throws SQLException;

	Book select(String pCode) throws SQLException;

	List<Book> select() throws SQLException;
}
