package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.HouseDto;
import com.ssafy.happyhouse.model.SearchCondition;
import com.ssafy.happyhouse.model.mapper.HouseMapper;

@Service
public class HouseServiceImpl implements HouseService{

	private static final Logger logger = LoggerFactory.getLogger(HouseServiceImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<HouseDto> findApt(String dong) throws Exception {
		return sqlSession.getMapper(HouseMapper.class).findApt(dong);
	}
	
	@Override
	public List<HouseDto> pagingSearch(SearchCondition condition) throws Exception {
		return sqlSession.getMapper(HouseMapper.class).pagingSearch(condition);
	}
	
	@Override
	public List<HouseDto> setMarker(String dong) throws Exception {
		if (dong == "" || dong == null) dong = "%";
		return sqlSession.getMapper(HouseMapper.class).setMarker(dong);
	}
}
