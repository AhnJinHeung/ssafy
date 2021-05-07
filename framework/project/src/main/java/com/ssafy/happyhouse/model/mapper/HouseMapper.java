package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.AddressDto;
import com.ssafy.happyhouse.model.HouseDto;
import com.ssafy.happyhouse.model.SearchCondition;

public interface HouseMapper {
	public List<HouseDto> findApt(String dong) throws SQLException;
	
	public List<HouseDto> pagingSearch(SearchCondition condition) throws SQLException;
	
	public List<HouseDto> setMarker(String dong) throws SQLException;
}
