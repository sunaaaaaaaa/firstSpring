package com.kh.spring.common.mail.handler;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailHandler {

	@PostMapping("mail")		//매개변수가 그때마다 달라서 ReuqestParam을 생략 할수없음
	public String writeMailTemplate(@RequestParam Map<String,String> template) { //여기가 파람이라 jsp에서도 파람.어쩌고임
		//상품광고,비번찾기,회원가입,주문관련 등 필요한 값이 달라서 Map으로 담음
		return "mail-template/"+template.get("mail-template");
	}
	
	
}
