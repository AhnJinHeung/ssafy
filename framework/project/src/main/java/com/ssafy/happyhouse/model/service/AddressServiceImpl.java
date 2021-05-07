package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.AddressDto;
import com.ssafy.happyhouse.model.mapper.AddressMapper;

@Service
public class AddressServiceImpl implements AddressService {

	private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<AddressDto> searchSido() throws Exception {
		return sqlSession.getMapper(AddressMapper.class).searchSido();
	}
	
	@Override
	public List<AddressDto> searchGugun(String sido) throws Exception {
		return sqlSession.getMapper(AddressMapper.class).searchGugun(sido);
	}

	@Override
	public List<AddressDto> searchDong(String gugun) throws Exception {
		return sqlSession.getMapper(AddressMapper.class).searchDong(gugun);
	}
	
	@Override
//	public AddressDto searchPosition(String gugun, String dong) throws SQLException {
	public AddressDto searchPosition(Map<String, String> map) throws Exception {
		return sqlSession.getMapper(AddressMapper.class).searchPosition(map);
	}
}
