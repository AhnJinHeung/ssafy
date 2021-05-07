package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.AddressDto;
import com.ssafy.happyhouse.model.HouseDto;
import com.ssafy.happyhouse.model.SearchCondition;

public interface HouseService {
	public List<HouseDto> findApt(String dong) throws Exception;
	
	public List<HouseDto> pagingSearch(SearchCondition condition) throws Exception;
	
	public List<HouseDto> setMarker(String dong) throws Exception;
}
