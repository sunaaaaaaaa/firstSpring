package com.kh.spring.member.controller;


import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.CookieGenerator;

import com.kh.spring.common.code.ErrorCode;
import com.kh.spring.common.exception.HandlableException;
import com.kh.spring.common.validator.VaildatorResult;
import com.kh.spring.member.model.dto.Member;
import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.service.MemberServiceImpl;
import com.kh.spring.member.validator.JoinForm;
import com.kh.spring.member.validator.JoinFormValidator;


//1. @Controller: 해당 클래스를 applicationCaontext에 bean으로 등록
//	 			Controller와 관련된 annotation을 사용할수있게 해준다.
//2. @RequestMapping : 어떤 요청 URL과 Controller의 메소드를 매필할지 지정
//				클래스 위에 선언할경우, 해당 클래스의 모든 메소드가 지정된 경로를 상위경로로 가짐
//3. @GetMapping : 어떤 GET방식의 요청 URL과 Controller의 메소드에 매핑할지 지정
//4. @PostMapping : 어떤 Post방식의 요청 URL과 Controller의 메소드에 매핑할지 지정
//5. @RequestParam : 요청파라미터를 컨트롤러 메소드의 매개변수에 바인드
//					단 Content=type이 application/x-www-form-urlEncoded인 경우에만!
//					FormHttpMessageConverter가 동작
//					@RequestParam 속성  
//					name : 요청파라미터명, 매개변수명과 요청파라미터명이 같은 경우 생략
//					required : 요청파라미터 필수 여부 지정, default :true
//					defaultValue : 요청 파라미터가 전달되지 않은 경우 지정할 기본 값
//6. @RequestBody : 요청 body를 읽어서 자바의 객체에 바인드
//					application/x-www-form-urlEncoded를 지원하지 않는다.
//7. @ModelAttribute : 요청 파라미터를 setter를 사용해서 객체에 바인드, Model객체에 바인드된 객체를 자동으로 저장
//8. @RequestHeader : 요청헤더를 컨트롤러의 매개변수에 바인드
//9. @SessionAttribute : 원하는 session의 속성값을 매개변수에 바인드
//10.@CookieValue: 원하는 cookie의 값을 매개변수에 바인드
//11.@PathVariable : url 템플릿에 담긴 파라미터값을 매개변수에 바인드
//12.@ResponseBody : 메서드가 반환하는 값을 응답body에 작성
//13. Servlet객체를 매개변수에 선언해 주입받을 수 있다.
// (HttpServletRequest, HttpServletResponse, HttpSession) :직접적으로 사용하지않고 annotation으로 씀. api요구시 사용

@Controller
@RequestMapping("member")
public class MemberController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final MemberService memberService;
	private final JoinFormValidator joinFormValidator;
	
	//트렌디한 의존성주입
	public MemberController(MemberService memberService, JoinFormValidator joinFormValidator) {
		super();
		this.memberService = memberService;
		this.joinFormValidator = joinFormValidator;
	}
	
	//model의 Attribute중 속성명이 joinForm인 속성이 있는 경우에
	//WebDataBinder의 속성을 초기화
	@InitBinder(value="joinForm") //value지정 안하면 Member나 이런거요청하는거 다 초기화되버림
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(joinFormValidator); //등록
	}

	@GetMapping("join") //@ModelAttribute생략
	public void joinForm(Model model) {
		model.addAttribute(new JoinForm()).addAttribute("error",new VaildatorResult().getError()); //지금은 필요없지만 spring boot때 이런식으로 작성해야함
	}
	
	@PostMapping("join") //@ModelAttribute생략 ->attribute에 파라미터로 넣은 객체가 자동으로 추가됨 명명규칙에 의해서(대문자->소문자)
	public String join(@Validated JoinForm form,Errors errors,Model model,HttpSession session,RedirectAttributes redirectAttr) { //Errors객체는 반드시 검증할 객체의 바로 뒤에 작성
		
		VaildatorResult vr = new VaildatorResult();
		model.addAttribute("error",vr.getError());
		if(errors.hasErrors()) { //실패한건 있는지 확인 (에러값도 errors안에 담겨있음)
			//한건이라도 있으면
			vr.addErrors(errors); //에러도 우리가만든 VaildatorResult Map객체 안에 에러 넣어줌(저장해서 다시 출력해주기위함)
			return "member/join";
		}
		//메일발송
		String token = UUID.randomUUID().toString(); //토큰값 만들어줌
		session.setAttribute("persistToken", token);//세션에넣어줌
		session.setAttribute("persistUser", form); //가입유저넣어줌
		
		redirectAttr.addFlashAttribute("message","회원가입을 위한 이메일이 발송되었습니다."); //redirect시 메세지 띄어줌
		
		memberService.authenticateByEmail(form,token); //메일발송
		return "redirect:/"; 
	} 
	
	@GetMapping("join-impl/{token}") //join-auth-email.jsp에 url이 join-impl임 
	public String joinImpl(@PathVariable String token //PathVariable로 {token}과 매핑해줌
							,@SessionAttribute(value="persistToken", required=false) String persistToken//토큰값의 null값에 대해 처리해줌(필수값이아님)->에러메세지띄게해줌
							,@SessionAttribute(value="persistUser", required=false) JoinForm form 
							,HttpSession session    //토큰값 지우기용
							,RedirectAttributes redirectAttr) { //메세지 띄어주기용
		
		if(!token.equals(persistToken)) {
			throw new HandlableException(ErrorCode.AUTHENTICATION_FAILED_ERROR); //토큰값 인증실패(다름)
		}
		
		memberService.inserMember(form); //버튼누를시 회원가입
		
		session.removeAttribute("persistToken"); //토큰만료시킴 (두번 eccess하지않기위함)
		session.removeAttribute("persistUser");
		redirectAttr.addFlashAttribute("message","환영합니다."); //redirect시 메세지 띄어줌
		return "redirect:/member/login";
	}
	
	@PostMapping("join-json")
	public String joinWithJson(@RequestBody Member member) {
		logger.debug(member.toString());
		return "redirect:/";
	}
	
	//로그인 페이지 이동 메소드 
	@GetMapping("login")
	public void login() {
		
		//핸들러블exception사용 ex)로그인페이지 넘기자마자 예뢰처리해서 넘겨줌
		//throw new HandlableException(ErrorCode.AUTHENTICATION_FAILED_ERROR);
		
	}
	
	//로그링 실행 메소드 (재지정 WEB-INF/views/member/mypage.jsp ; id,비번출력)
	@PostMapping("login")										//redirect시에도 attribute데이터 보관(spring api; RedirectAttributes)Model 인터페이스 상속(Model이랑 같음)
	public String loginImpl(Member member,HttpSession session,RedirectAttributes redirectAttr) { //객체 파라미터일시 @ModelAttribute 생략 -->(Member)
		Member certifiedUser = memberService.authenticateUser(member); 
		
		if(certifiedUser==null) {
			redirectAttr.addFlashAttribute("message", "아이디나 비밀번호가 틀렸습니다"); // FlashAttribute:일회성 ex) 회원가입하고 index로 redirect할때 msg보내줄때 사용
			return "redirect:/member/login"; //foword해도 상관없음
		}
		session.setAttribute("authentication", certifiedUser);
		return "redirect:/member/mypage";
	}
	
	@GetMapping("mypage") //페이지 이동용 메소드(redirect하기 위해서 필요함)
	public String mypage(@SessionAttribute(name ="authentication")Member certifiedUser
						, @CookieValue(name="JSESSIONID")String sessionId
						,HttpServletResponse response) { //view안써주면 안뜸
		
		//JESSIONID 쿠키 출력
		logger.debug(sessionId);
		
		//Session의 authentication속성 값 출력
		logger.debug(certifiedUser.toString());
		
		//쿠키 생성 및 응답헤더에 추가 (Spring api: cookieGenerator)
		CookieGenerator cookieGenerator = new CookieGenerator();
		cookieGenerator.setCookieName("testCookie");
		cookieGenerator.addCookie(response, "CookeTest_hahahahahahha");
		
		return "member/mypage";
	}
	
	
	@GetMapping("id-check")
	@ResponseBody //여기에 return값이 담겨서 날아감
	public String idCheck(String userId) {
		
		Member member = memberService.selectMemberByUserId(userId);
		
		if(member==null) {
			return "available"; //반환값은 response.text()와 view페이지랑 void 3가지만 존재
		}else {
			return "disable";
		}
	}
	
	
	
	
	
}
