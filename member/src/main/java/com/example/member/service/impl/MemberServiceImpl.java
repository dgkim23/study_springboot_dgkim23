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

}
