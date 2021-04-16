package com.ssafy.backend.service;

import java.util.List;

import com.ssafy.backend.dto.Book;

public interface BookService {
	public void doRegist(Book book) throws Exception;
	
	public List<Book> doList() throws Exception;
}
