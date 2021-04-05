package com.ssafy.member.service;

import com.ssafy.member.dto.MemberDto;

public interface MemberService {

//	회원가입
	void registerMember(MemberDto memberDto);
	
//	로그인
	MemberDto login(String userId, String userPwd);
	
//	회원정보 수정을 위한 회원의 모든 정보 얻기
	MemberDto getMember(String userId);
	
//	회원정보 수정
	void modifyMember(MemberDto memberDto);
	
//	회원탈퇴
	void deleteMember(String userId);
	
}
