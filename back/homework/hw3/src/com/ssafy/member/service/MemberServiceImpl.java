package com.ssafy.member.service;

import com.ssafy.member.dao.MemberDaoImpl;
import com.ssafy.member.dto.MemberDto;

public class MemberServiceImpl implements MemberService {
	
	private static MemberService memberService;
	
	private MemberServiceImpl() {}

	public static MemberService getMemberService() {
		if(memberService == null)
			memberService = new MemberServiceImpl();
		return memberService;
	}

	@Override
	public void registerMember(MemberDto memberDto) {
		MemberDaoImpl.getMemberDao().registerMember(memberDto);
	}

	@Override
	public MemberDto login(String userId, String userPwd) {
		return MemberDaoImpl.getMemberDao().login(userId, userPwd);
	}

	@Override
	public MemberDto getMember(String userId) {
		return MemberDaoImpl.getMemberDao().getMember(userId);
	}

	@Override
	public void modifyMember(MemberDto memberDto) {
		MemberDaoImpl.getMemberDao().modifyMember(memberDto);
	}

	@Override
	public void deleteMember(String userId) {
		MemberDaoImpl.getMemberDao().deleteMember(userId);
	}

}
