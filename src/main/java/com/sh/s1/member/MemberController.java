package com.sh.s1.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	
	@Autowired
	private MemberService memberService;
	
	//memberJoin // /member/memberJoin GET
	@RequestMapping(value = "/member/memberJoin")
	public String memberJoin() {
		return "member/memberJoin";
	}
	
	// memberJoin2 // /member/memberJoin POST
	// overloading

	@RequestMapping(value = "/member/memberJoin", method = RequestMethod.POST)
	public void memberJoin(MemberDTO memberDTO) throws Exception{
			
		int result = memberService.memberJoin(memberDTO);
		
		System.out.println(result);
	}
	
	
	//memberLogin print   // URL=/member/memberLogin
	
	@RequestMapping(value = "/member/memberLogin")
	public String memberLogin() {
		//System.out.println(name);
		//System.out.println(age);
		
		//String name = request.getParameter("name");
		//int age = Integer.parseInt(request.getParameter("age"));
		
		
		
		System.out.println("memberLogin test");
		
		
		
		// /WEB-INF/views/member/memberLogin.jsp
		// servlet-context에서 prefix, suffix로 경로를 완성시켜준다.
		return "member/memberLogin";
	}
	
	//memberLogin2 print 
	//overloading
	@RequestMapping(value = "/member/memberLogin", method = RequestMethod.POST)
	public String memberLogin(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		
		memberService.memberLogin(memberDTO);
		
		System.out.println(memberDTO);
		request.setAttribute("dto", memberDTO);
		
		//prefix, suffix로 앞 뒤 경로명과 확장자를 맞춰준다.
		return "/member/memberPage";
		
	}
	
	
}
