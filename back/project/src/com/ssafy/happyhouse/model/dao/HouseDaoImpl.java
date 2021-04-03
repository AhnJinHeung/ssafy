package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.model.HouseDto;
import com.ssafy.util.DBUtil;

public class HouseDaoImpl implements HouseDao {
	
	private static HouseDao houseDao;
	
	private HouseDaoImpl() {
	}
	
	public static HouseDao getHouseDao() {
		if (houseDao == null) {
			houseDao = new HouseDaoImpl();
		}
		return houseDao;
	}
	
	@Override
	public List<HouseDto> findApt(String dong) throws SQLException{
		List<HouseDto> list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select AptName, dealAmount, area, buildYear from housedeal where dong = ?";
		
		// throws할 것이기 때문에 catch는 없다.
		try {
			con = DBUtil.getConnect();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			HouseDto dto = null;
			while(rs.next()) {
				dto = new HouseDto();
				dto.setAptName(rs.getString(1));
				dto.setDealAmount(rs.getString(2));
				dto.setArea(rs.getString(3));
				dto.setBuildYear(rs.getString(4));
				list.add(dto);
			}
		}finally {
			//닫는 순서 유의
			DBUtil.close(rs, pstmt, con);
		}
		
		return list;
	}
}
