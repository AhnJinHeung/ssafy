package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.AddressDto;

public interface AddressService {
	
	public List<AddressDto> searchSido() throws Exception;
	
	public List<AddressDto> searchGugun(String sido) throws Exception;
	
	public List<AddressDto> searchDong(String gugun) throws Exception;
	
	public AddressDto searchPosition(Map<String, String> map) throws Exception;

}
