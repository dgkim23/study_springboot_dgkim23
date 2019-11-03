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
}
