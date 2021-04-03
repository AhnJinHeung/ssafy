package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.HouseDto;

public interface HouseService {
	public List<HouseDto> findApt(String dong)  throws SQLException;
}
