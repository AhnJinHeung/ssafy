package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.happyhouse.model.AddressDto;
import com.ssafy.happyhouse.model.HouseDto;
import com.ssafy.happyhouse.model.service.AddressService;
import com.ssafy.happyhouse.model.service.AddressServiceImpl;
import com.ssafy.util.DBUtil;

public class AddressDaoImpl implements AddressDao {

	private static AddressDao addressDao;

	private AddressDaoImpl() {
	}

	public static AddressDao getAddressService() {
		if (addressDao == null)
			addressDao = new AddressDaoImpl();
		return addressDao;
	}

	@Override
	public List<AddressDto> searchGugun(String sido) throws SQLException {
		List<AddressDto> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select distinct gugun from baseaddress where city = ?";

		try {
			con = DBUtil.getConnect();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, sido);
			rs = pstmt.executeQuery();
			AddressDto dto = null;
			while (rs.next()) {
				dto = new AddressDto();
				dto.setGugun(rs.getString(1));
				list.add(dto);
			}
		} finally {
			// 닫는 순서 유의
			DBUtil.close(rs, pstmt, con);
		}

		return list;
	}

	@Override
	public List<AddressDto> searchDong(String gugun) throws SQLException {
		List<AddressDto> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select distinct dong from baseaddress where gugun = ?";

		try {
			con = DBUtil.getConnect();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, gugun);
			rs = pstmt.executeQuery();
			AddressDto dto = null;
			while (rs.next()) {
				dto = new AddressDto();
				dto.setDong(rs.getString(1));
				list.add(dto);
			}
		} finally {
			// 닫는 순서 유의
			DBUtil.close(rs, pstmt, con);
		}

		return list;
	}

}
