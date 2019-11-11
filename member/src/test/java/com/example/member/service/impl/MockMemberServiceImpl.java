package com.example.member.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.member.MemberVO;
import com.example.member.dao.MemberDao;
import com.example.member.service.MemberService;

@Service("mockMemberService")
public class MockMemberServiceImpl implements MemberService{

	@Resource(name="memberService")
	private MemberService memberService;
	
	
	@Override
	public int insertMemberOne(MemberVO pvo) {
		return memberService.insertMemberOne(pvo);
	}


	@Override
	public int updateMemberOne(MemberVO pvo) {
		return memberService.updateMemberOne(pvo);
	}


	@Override
	public MemberVO selectMemberOne() {
		return memberService.selectMemberOne();
	}


	@Override
	public int deleteMemberOne(long memberSql) {
		return memberService.deleteMemberOne(memberSql);
	}


	@Override
	public boolean httpTransfer() {
		System.out.println("테스트입니다");
		System.out.println("연동후결과값리턴");
		return true;
	}


	@Override
	public MemberVO selectMemberOne(MemberVO vo) {
		return memberService.selectMemberOne(vo);
	}
	
	@Override
	public MemberVO selectMember(MemberVO vo) {
		return memberService.selectMember(vo);
	}
}
