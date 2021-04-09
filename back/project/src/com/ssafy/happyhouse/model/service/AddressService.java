package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.AddressDto;

public interface AddressService {
	public List<AddressDto> searchGugun(String sido) throws SQLException;
	public List<AddressDto> searchDong(String gugun) throws SQLException;
}
