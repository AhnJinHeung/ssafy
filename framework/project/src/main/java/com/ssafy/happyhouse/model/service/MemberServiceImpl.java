package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void registerMember(MemberDto memberDto) throws Exception {
		sqlSession.getMapper(MemberMapper.class).registerMember(memberDto);
	}

	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		MemberDto memberDto = sqlSession.getMapper(MemberMapper.class).login(map);
		memberDto.setInterest(findInterest(memberDto.getUserId()));
		return memberDto;
	}

	@Override
	public MemberDto getMember(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(MemberMapper.class).getMember(userId);
	}

	@Override
	public void modifyMember(MemberDto memberDto) throws Exception {
		sqlSession.getMapper(MemberMapper.class).modifyMember(memberDto);
	}

	@Override
	public void deleteMember(String userId) throws Exception {
		sqlSession.getMapper(MemberMapper.class).deleteMember(userId);
	}

	public void addInterest(Map<String, String> map) throws Exception {
		sqlSession.getMapper(MemberMapper.class).addInterest(map);
		
	}
	
	public void removeInterest(Map<String, String> map) throws Exception {
		sqlSession.getMapper(MemberMapper.class).removeInterest(map);
	}
	
	public List<String> findInterest(String userid) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).findInterest(userid);
	}
}
