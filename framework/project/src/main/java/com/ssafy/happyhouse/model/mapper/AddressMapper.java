package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.AddressDto;

public interface AddressMapper {
	
	public List<AddressDto> searchSido() throws SQLException;
	
	public List<AddressDto> searchGugun(String sido) throws SQLException;
	
	public List<AddressDto> searchDong(String gugun) throws SQLException;
	
	public AddressDto searchPosition(Map<String, String> map) throws SQLException;
}
