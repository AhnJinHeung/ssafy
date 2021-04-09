package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.AddressDto;

public interface AddressDao {
	public List<AddressDto> searchGugun(String sido) throws SQLException;
	public List<AddressDto> searchDong(String gugun) throws SQLException;
}
