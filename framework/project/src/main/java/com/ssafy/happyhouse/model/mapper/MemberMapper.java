package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.MemberDto;

public interface MemberMapper {

//	회원가입
	void registerMember(MemberDto memberDto) throws SQLException;
	
//	로그인
	MemberDto login(Map<String, String> map) throws SQLException;
	
//	회원정보 수정을 위한 회원의 모든 정보 얻기
	MemberDto getMember(String userId) throws SQLException;
	
//	회원정보 수정
	void modifyMember(MemberDto memberDto) throws SQLException;
	
//	회원탈퇴
	void deleteMember(String userId) throws SQLException;
	
	public void addInterest(Map<String, String> map) throws SQLException;
	
	public void removeInterest(Map<String, String> map) throws SQLException;
	
	public List<String> findInterest(String userid) throws SQLException;
}
