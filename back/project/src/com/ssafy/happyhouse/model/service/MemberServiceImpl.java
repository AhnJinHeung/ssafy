package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	
	private static MemberService memberService;
	
	private MemberServiceImpl() {}
	
	public static MemberService getMemberService() {
		if (memberService == null) {
			memberService = new MemberServiceImpl();
		}
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyMember(MemberDto memberDto) {
		MemberDaoImpl.getMemberDao().modifyMember(memberDto);
	}

	@Override
	public void deleteMember(String userId) {
		MemberDaoImpl.getMemberDao().deleteMember(userId);
	}

	public void addInterest(String userid, String gugun, String dong) {
		MemberDaoImpl.getMemberDao().addInterest(userid, gugun, dong);
	}
	
	public void removeInterest(String userid, String gugun, String dong) {
		MemberDaoImpl.getMemberDao().removeInterest(userid, gugun, dong);
	}
	
	public List<String> findInterest(String userid) {
		return MemberDaoImpl.getMemberDao().findInterest(userid);
	}
}
