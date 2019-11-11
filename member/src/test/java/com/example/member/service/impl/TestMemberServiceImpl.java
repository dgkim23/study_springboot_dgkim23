package com.example.member.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

	//@Resource(name="memberService")
	@Resource(name="mockMemberService")
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
	
	
	@Test
	@Transactional //롤백기능
	public void 멤버_업데이트_테스트() {
		pvo = memberService.selectMemberOne();
		assertNotNull(pvo);
		
		String usrPass = pvo.getUsrPass();
		pvo.setUsrPass("2222");
		
		System.out.println("pvo.getMemberSql1 : " +pvo.getMemberSql());
		
		int result = memberService.updateMemberOne(pvo);
		
		MemberVO rvo = memberService.selectMemberOne();
		
		assertNotNull(rvo);		
		
		assertEquals(pvo.getMemberSql(),rvo.getMemberSql());		
		
		assertNotEquals(usrPass,rvo.getUsrPass());		
		
		assertTrue( 1 <= result );
	}
	
	@Test
	@Transactional //롤백기능
	public void 멤버_업데이트_실패_테스트() {
		int result = memberService.insertMemberOne(pvo);
		assertTrue( 1 <= result );
		
		
		pvo = memberService.selectMemberOne();
		assertNotNull(pvo);
		
		System.out.println("pvo.getMemberSql2 : " +pvo.getMemberSql());
		pvo.setUsrPass("12345678901");
		
		Assertions.assertThrows(DataIntegrityViolationException.class,new Executable() {
			@Override
			public void execute() throws Throwable {
				memberService.updateMemberOne(pvo);
			}
		});
	}
	
	
	
	@Test
	@Transactional //롤백기능
	public void 멤버_딜리트_테스트() {
		pvo = memberService.selectMemberOne();
		assertNotNull(pvo);
		System.out.println("pvo.getMemberSql3 : " +pvo.getMemberSql());
		
		int result = memberService.deleteMemberOne(pvo.getMemberSql());
		assertTrue( 1 <= result );
	}
	
	@Test
	public void 로그인_테스트() {
		String usrId = "dgkim23";
		String usrPass = "12345";
		
		MemberVO vo = new MemberVO();
		vo.setUsrId(usrId);
		vo.setUsrPass(usrPass);
		
		pvo = memberService.selectMemberOne(vo);
		assertNotNull(pvo);
		System.out.println("pvo.getUsrName : " +pvo.getUsrName());
		
	}
	
	/*
	@Test
	public void ex1() {
		fail();
	}
	@Test
	public void ex2() {
		throw new RuntimeException();
	}
	*/

}
