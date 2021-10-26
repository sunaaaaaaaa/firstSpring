package com.kh.spring.member.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring.common.code.Config;
import com.kh.spring.common.mail.MailSender;
import com.kh.spring.member.model.dto.Member;
import com.kh.spring.member.model.repository.MemberRepository;
import com.kh.spring.member.validator.JoinForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //롬복으로 매개변수있는 생성자만들어줌. final로 지정하면됨 (매개변수없는 기본생성자는 @NoArgument어쩌고로 만들수있음. final없어야됨)
public class MemberServiceImpl implements MemberService{

	private final MemberRepository memberRepository; 
	private final RestTemplate template;
	private final MailSender mailSender;
	private final PasswordEncoder passwordEncoder;
	
	//회원가입
	public void inserMember(JoinForm form) {
		form.setPassword(passwordEncoder.encode(form.getPassword()));//패스워드 암호화
		memberRepository.insertMember(form);
	}

	//로그인유지
	public Member authenticateUser(Member member) {
		
		Member storedMember = memberRepository.selectMemberByUserId(member.getUserId()); //사용자 아이디 찾아서
		
		if(storedMember != null && passwordEncoder.matches(member.getPassword(), storedMember.getPassword())) { //회원이고 패스워드가 같다면
			return storedMember;
		}
		return null; //패스워드 안같으면 null
	}

	public Member selectMemberByUserId(String userId) {
		return memberRepository.selectMemberByUserId(userId);
	}

	//이메일발송
	public void authenticateByEmail(JoinForm form, String token) {
		//post요청
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("mail-template","join-auth-email"); //mailHandler에서 지정한거랑 jsp사용할거
		body.add("userId", form.getUserId()); //파라미터 넘긴값(이메일에 넣어줄값)
		body.add("persistToken", token);
		
		//RestTemplate의 기본 ContentType이 application/json이다
		RequestEntity<MultiValueMap<String, String>> request =
				RequestEntity.post(Config.DOMAIN.DESC+"/mail") //여기서 Mailhandler컨트롤러로 보내줌
				.accept(MediaType.APPLICATION_FORM_URLENCODED) //헤더값 -->인코디드 한번더지정해줘야함
				.body(body);
		
		String htmlText = template.exchange(request, String.class).getBody();//데이터받아옴
		mailSender.sendEmail(form.getEmail(), "회원가입을 축하합니다", htmlText); //메일센더에게 메일보내라고함
		
		
		
	}
	
	
}
