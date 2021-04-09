package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.AddressDto;
import com.ssafy.happyhouse.model.HouseDto;
import com.ssafy.happyhouse.model.dao.AddressDao;
import com.ssafy.happyhouse.model.dao.AddressDaoImpl;
import com.ssafy.happyhouse.model.dao.HouseDao;
import com.ssafy.happyhouse.model.dao.HouseDaoImpl;

public class AddressServiceImpl implements AddressService {

	private static AddressService addressService;

	private AddressServiceImpl() {
	}

	public static AddressService getAddressService() {
		if (addressService == null)
			addressService = new AddressServiceImpl();
		return addressService;
	}

	@Override
	public List<AddressDto> searchGugun(String sido) throws SQLException {
		List<AddressDto> list = null;
		AddressDao dao = AddressDaoImpl.getAddressService();
		list = dao.searchGugun(sido);
		return list;
	}

	@Override
	public List<AddressDto> searchDong(String gugun) throws SQLException {
		List<AddressDto> list = null;
		AddressDao dao = AddressDaoImpl.getAddressService();
		list = dao.searchDong(gugun);
		return list;
	}

}
