package com.example.member.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import javax.annotation.Resource;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.example.ApplicationTests;
import com.example.member.MemberVO;
import com.example.member.service.MemberService;

public class TestMemberServiceImpl extends ApplicationTests {

	@Resource(name="memberService")
	private MemberService memberService;
	
	private MemberVO pvo;
	
	//각 메서드 마다 최초실행
	@BeforeEach
	public void 셋팅() {
		pvo = new MemberVO();
		pvo.setUsrId("dgkim23");
		pvo.setUsrName("김동구2");
		pvo.setUsrAddr("서울2");
		pvo.setUsrPass("1234");
		System.out.println("pvo Object Address : " +pvo.getClass().hashCode());
	}
	
	@Test
	public void 테스트() {
	}
	
	@Test
	@Transactional //롤백기능
	public void 멤버_인서트_테스트() {
		int result = memberService.insertMemberOne(pvo);
		/*if (result < 1) {
			//throw new RuntimeException();
			//간편버전
			fail();
			
		}*/
		//상위버전
		assertTrue( 1 <= result );
	}
	
	@Test
	public void 멤버_인서트_실패_테스트() {
		Assertions.assertThrows(DataIntegrityViolationException.class,new Executable() {

			@Override
			public void execute() throws Throwable {

				pvo.setUsrPass("12345678901");
				
				int result = memberService.insertMemberOne(pvo);
				
				//상위버전
				//assertTrue( 1 <= result );

			}

		});

	}
}
