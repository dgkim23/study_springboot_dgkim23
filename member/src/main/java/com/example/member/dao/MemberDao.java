package com.example.member.dao;

import java.util.List;

import com.example.member.MemberVO;

public interface MemberDao {
	public List<MemberVO> selectMemberList() throws Exception;

	public int insertMemberOne(MemberVO pvo);
    
}
