package com.ssafy.news;

import java.util.List;

public interface INewsDAO {
	
	List<News> getNewsList(String url);
	
	public News search(int index);
}