package com.sh.s1.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//memberJoin print   // URL=/member/memberLogin
	
	@RequestMapping(value = "/member/memberLogin")
	public String memberJoin() {
		System.out.println("memberLogin test");
		
		// /WEB-INF/views/member/memberLogin.jsp
		// servlet-context에서 prefix, suffix로 경로를 완성시켜준다.
		return "member/memberLogin";
	}
	
	//memberLogin2 print 
	@RequestMapping(value = "/member/memberLogin", method = RequestMethod.POST)
	public void memberLogin2(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		
		memberService.memberLogin(memberDTO);
		
		System.out.println(memberDTO);
		
	}
}
