package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.HouseDto;

public interface HouseDao {
	public List<HouseDto> findApt(String dong) throws SQLException;
}
