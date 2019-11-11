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
	
	//�� �޼��� ���� ���ʽ���
	@BeforeEach
	public void ����() {
		pvo = new MemberVO();
		pvo.setUsrId("dgkim23");
		pvo.setUsrName("�赿��2");
		pvo.setUsrAddr("����2");
		pvo.setUsrPass("1234");
		System.out.println("pvo Object Address : " +pvo.getClass().hashCode());
	}
	
	@Test
	public void �׽�Ʈ() {
	}
	
	@Test
	@Transactional //�ѹ���
	public void ���_�μ�Ʈ_�׽�Ʈ() {
		int result = memberService.insertMemberOne(pvo);
		/*if (result < 1) {
			//throw new RuntimeException();
			//�������
			fail();
			
		}*/
		//��������
		assertTrue( 1 <= result );
	}
	
	@Test
	public void ���_�μ�Ʈ_����_�׽�Ʈ() {
		Assertions.assertThrows(DataIntegrityViolationException.class,new Executable() {

			@Override
			public void execute() throws Throwable {

				pvo.setUsrPass("12345678901");
				
				int result = memberService.insertMemberOne(pvo);
				
				//��������
				//assertTrue( 1 <= result );

			}

		});

	}
	
	
	@Test
	@Transactional //�ѹ���
	public void ���_������Ʈ_�׽�Ʈ() {
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
	@Transactional //�ѹ���
	public void ���_������Ʈ_����_�׽�Ʈ() {
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
	@Transactional //�ѹ���
	public void ���_����Ʈ_�׽�Ʈ() {
		pvo = memberService.selectMemberOne();
		assertNotNull(pvo);
		System.out.println("pvo.getMemberSql3 : " +pvo.getMemberSql());
		
		int result = memberService.deleteMemberOne(pvo.getMemberSql());
		assertTrue( 1 <= result );
	}
	
	@Test
	public void �α���_�׽�Ʈ() {
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
