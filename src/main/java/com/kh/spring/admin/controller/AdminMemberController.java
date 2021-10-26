package com.kh.spring.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.admin.model.service.AdminMemberService;
import com.kh.spring.member.model.dto.Member;

@Controller
@RequestMapping("admin")
public class AdminMemberController {

	//get방식으로 /admin/member-list로 요청이 올 경우 호출될 controller메소드 작성
	//DataBase에서 현재 모든 회원의 정보를 조회해서, Controller 메소드에서 출력
	//index.jsp로 요청 재지정
	//AdminMemberControllerTest클래스를 만들어 200번 응답코드가 반환되면 테스트 통과하도록
	//테스트 메소드 작성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminMemberService adminService;
	
	@GetMapping("member-list")
	public void selectAllMember(Model model) {
		List<Member> allMember =adminService.selectAllMember();
		model.addAttribute("members", allMember); //member-list.jsp에서 el태그로 members 넣어주고있음
	}
	
	
	
	
	
	
}
