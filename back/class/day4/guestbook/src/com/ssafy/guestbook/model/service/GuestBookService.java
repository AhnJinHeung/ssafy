package com.ssafy.guestbook.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.guestbook.model.GuestBookDto;

public interface GuestBookService {

//	글작성
	void registerArticle(GuestBookDto guestBookDto) throws Exception;
	
//	글목록
	List<GuestBookDto> listArticle(String key, String word) throws Exception;
	
//	글수정을 위한 글얻기
	GuestBookDto getArticle(int articleNo) throws Exception;
	
//	글수정
	void modifyArticle(GuestBookDto guestBookDto) throws Exception;
	
//	글삭제
	void deleteArticle(int articleNo) throws Exception;
	
}
