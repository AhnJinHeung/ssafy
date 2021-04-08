package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.GuestBookDto;
import com.ssafy.model.dao.GuestBookDao;
import com.ssafy.model.dao.GuestBookDaoImpl;
import com.ssafy.util.PageConstance;
import com.ssafy.util.PageNavigation;

public class GuestBookServiceImpl implements GuestBookService {
	
	private GuestBookDao guestBookDao;
	
	public GuestBookServiceImpl() {
		guestBookDao = new GuestBookDaoImpl();
	}

	@Override
	public void writeArticle(GuestBookDto guestBookDto) throws Exception {
		if(guestBookDto.getSubject() == null || guestBookDto.getContent() == null) {
			throw new Exception();
		}
		guestBookDao.writeArticle(guestBookDto);
	}

	@Override
	public List<GuestBookDto> listArticle(int pg, String key, String word) throws Exception {
		int start = (pg - 1) * PageConstance.LIST_SIZE;
		key = key == null ? "" : key;
		word = word == null ? "" : word;
		return guestBookDao.listArticle(start, key, word);
	}
	
	public PageNavigation makeNavigator(int pg, String key, String word) throws Exception {
		int naviSize = PageConstance.NAVI_SIZE;
		PageNavigation navigation = new PageNavigation();
		int totalCount = guestBookDao.getTotalCount(key, word);
		navigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / PageConstance.LIST_SIZE + 1;
		navigation.setTotalPageCount(totalPageCount);
		navigation.setCurrentPage(pg);
		navigation.setNaviSize(naviSize);
		navigation.setStartRange(pg <= naviSize);
		navigation.setEndRange((totalPageCount - 1) / naviSize * naviSize < pg);
		navigation.makeNavigator();
		return navigation;
	}

	@Override
	public GuestBookDto getArticle(int articleno) throws Exception {
		return guestBookDao.getArticle(articleno);
	}

	@Override
	public void modifyArticle(GuestBookDto guestBookDto) throws Exception {
		guestBookDao.modifyArticle(guestBookDto);
	}

	@Override
	public void deleteArticle(int articleno) throws Exception {
		guestBookDao.deleteArticle(articleno);
	}

}
