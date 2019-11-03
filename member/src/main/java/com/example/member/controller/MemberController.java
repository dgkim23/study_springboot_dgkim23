package com.example.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.member.MemberVO;
import com.example.member.dao.MemberDao;

@RestController
@EnableAutoConfiguration
//@RequestMapping("/main")
public class MemberController {

	//@Autowired
    //private MemberDao mapper;
	
	@RequestMapping("/main/member")
	public String main() throws Exception{
		
		//List<MemberVO> list = mapper.selectMemberList();
        
        //for(int i=0; i<list.size(); i++){
            //System.out.println("name : " + list.get(i).getName());
            //System.out.println("team : " + list.get(i).getTeam());
        //}        
        
		return "hello?";
	}
	
}

