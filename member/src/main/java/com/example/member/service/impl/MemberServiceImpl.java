package com.example.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.member.MemberVO;
import com.example.member.dao.MemberDao;
import com.example.member.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
    private MemberDao mapper;

	@Override
	public int insertMemberOne(MemberVO pvo) {
		return mapper.insertMemberOne(pvo);
	}
	
	@Override
	public int updateMemberOne(MemberVO pvo) {
		return mapper.updateMemberOne(pvo);
	}


	@Override
	public MemberVO selectMemberOne() {
		System.out.println("selectMemberOne 실행");
		return mapper.selectMemberOne();
	}
	
	@Override
	public MemberVO selectMemberOne(MemberVO vo) {
		System.out.println("selectMemberOne vo 실행");
		return mapper.selectMemberLogin(vo);
	}


	@Override
	public int deleteMemberOne(long memberSql) {
		return mapper.deleteMemberOne(memberSql);
	}


	@Override
	public boolean httpTransfer() {
		// 외부연동코드
		System.out.println("외부연동성공");
		return true;
	}

	@Override
	public MemberVO selectMember(MemberVO vo) {
		return mapper.selectMember(vo);
	}

}
