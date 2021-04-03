package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.HouseDto;
import com.ssafy.happyhouse.model.dao.HouseDao;
import com.ssafy.happyhouse.model.dao.HouseDaoImpl;

public class HouseServiceImpl implements HouseService{
	private static HouseService houseService;
	
	private HouseServiceImpl() {
	}
	
	public static HouseService gethouseService() {
		if (houseService == null) {
			houseService = new HouseServiceImpl();
		}
		return houseService;
	}
	@Override
	public List<HouseDto> findApt(String dong) throws SQLException{
		List<HouseDto> list = null;
		HouseDao dao = HouseDaoImpl.getHouseDao();
		list = dao.findApt(dong);
		return list;
	}

}
