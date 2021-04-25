package com.ssafy.test.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.test.model.dao.BookDaoImpl;
import com.ssafy.test.model.dto.Book;

public class BookServiceImpl implements BookService {
	private static BookService bookService;
	
	private BookServiceImpl() {}
	
	public static BookService getBookService() {
		if (bookService == null) {
			bookService = new BookServiceImpl();
		}
		return bookService;
	}
	
	@Override
	public void insert(Book product) throws SQLException {
		BookDaoImpl.getBookDao().insert(product);
	}

	@Override
	public Book select(String pCode) throws SQLException {
		return BookDaoImpl.getBookDao().select(pCode);
	}

	@Override
	public List<Book> select() throws SQLException {
		return BookDaoImpl.getBookDao().select();
	}
}
