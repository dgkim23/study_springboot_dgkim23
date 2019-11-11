package com.example.member.service;

import com.example.member.MemberVO;

public interface MemberService {
	int insertMemberOne(MemberVO pvo);
	
	int updateMemberOne(MemberVO pvo);

	MemberVO selectMemberOne();

	int deleteMemberOne(long memberSql);

	boolean httpTransfer();

	MemberVO selectMemberOne(MemberVO vo);
	
	MemberVO selectMember(MemberVO vo);
}
