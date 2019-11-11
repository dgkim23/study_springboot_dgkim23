package com.example.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.member.MemberVO;
import com.example.member.dao.MemberDao;
import com.example.member.service.MemberService;

@RestController
@EnableAutoConfiguration
//@RequestMapping("/main")
public class MemberController {

	//@Autowired
    //private MemberDao mapper;
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping("/main/member")
	public String main() throws Exception{
		
		//List<MemberVO> list = mapper.selectMemberList();
        
        //for(int i=0; i<list.size(); i++){
            //System.out.println("name : " + list.get(i).getName());
            //System.out.println("team : " + list.get(i).getTeam());
        //}        
        
		return "hello?";
	}

	@RequestMapping("/member/login")
	public Map<String, Object> login(HttpServletRequest req, HttpServletResponse res, HttpSession session) {
		String usrId = req.getParameter("usrId");
		String usrPass = req.getParameter("usrPass");
		Map<String, Object> result = new HashMap<String, Object>();
		System.out.println("usrId---->" + usrId);
		System.out.println("usrPass---->" + usrPass);
		
		MemberVO vo = new MemberVO();
		vo.setUsrId(usrId);
		vo.setUsrPass(usrPass);
		
		System.out.println("vo---->" + vo);
		vo = memberService.selectMemberOne(vo);
		System.out.println("vo2---->" + vo);
		
		if(null != vo) {
			result.put("result", "success");
			result.put("msg", "성공");
			session.setAttribute("sessionVO", vo);
		}else {
			result.put("result", "fail");
			result.put("msg", "실패");
		}
		
		return result;
	}

	@RequestMapping("/member/searchUser")
	public Map<String, Object> searchUser(HttpServletRequest req, HttpServletResponse res) {
		String usrId = req.getParameter("usrId");
		String usrTkn = req.getParameter("usrTkn");
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		MemberVO vo = new MemberVO();
		vo.setUsrId(usrId);
		vo.setUsrTkn(usrTkn);
		
		vo = memberService.selectMember(vo);
		
		result.put("obj", vo);
		
		
		return result;
	}
	
}

