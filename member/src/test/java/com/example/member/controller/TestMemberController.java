package com.example.member.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Map;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import com.example.ApplicationTests;
import com.example.member.MemberVO;

public class TestMemberController extends ApplicationTests {

	@Autowired
	private MemberController memberController;

	@Test
	public void 로그인() {
		
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse res = new MockHttpServletResponse();
		MockHttpSession session = new MockHttpSession();
		
		req.setParameter("usrId", "dgkim23");
		req.setParameter("usrPass", "12345");
		
	
		Map<String, Object> result = memberController.login(req, res, session);
		
		System.out.println("result---"+result);
		assertEquals(result.get("result"),"success");
		
		MemberVO sessionVO = (MemberVO)session.getAttribute("sessionVO");
		
		assertNotNull(sessionVO);
		
	}
	
	@Test
	public void 한사람정보갖고오기() {
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse res = new MockHttpServletResponse();
		
		req.setParameter("usrId", "dgkim23");
		req.setParameter("usrTkn", "test");
		
		Map<String, Object> result = (Map<String, Object>)memberController.searchUser(req, res);
		
		System.out.println("result->" + result);
		
		MemberVO vo = (MemberVO) result.get("obj");
		
		
		assertNotNull(vo);
	}

	

}