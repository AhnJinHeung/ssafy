package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.MemberDto;


public interface MemberService {

//	회원가입
	void registerMember(MemberDto memberDto) throws Exception;
	
//	로그인
	MemberDto login(Map<String, String> map) throws Exception;
	
//	회원정보 수정을 위한 회원의 모든 정보 얻기
	MemberDto getMember(String userId) throws Exception;
	
//	회원정보 수정
	void modifyMember(MemberDto memberDto) throws Exception;
	
//	회원탈퇴
	void deleteMember(String userId) throws Exception;
	
	public void addInterest(Map<String, String> map) throws Exception;
	
	public void removeInterest(Map<String, String> map) throws Exception;
	
	public List<String> findInterest(String userid) throws Exception;
	
}
