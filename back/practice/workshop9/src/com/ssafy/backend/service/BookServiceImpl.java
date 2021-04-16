package com.ssafy.backend.service;

import java.util.List;

import com.ssafy.backend.dao.BookDaoImpl;
import com.ssafy.backend.dto.Book;

public class BookServiceImpl implements BookService {
	private static BookService bookService;
	
	private BookServiceImpl() {}
	
	public static BookService getBookService() {
		if (bookService == null) 
			bookService = new BookServiceImpl();
		return bookService;
	}
	
	@Override
	public void doRegist(Book book) throws Exception {
		BookDaoImpl.getBookService().doRegist(book);
	}

	@Override
	public List<Book> doList() throws Exception {
		return BookDaoImpl.getBookService().doList();
	}
	
}
