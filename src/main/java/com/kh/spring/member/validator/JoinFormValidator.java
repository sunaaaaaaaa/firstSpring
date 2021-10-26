package com.kh.spring.member.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kh.spring.member.model.repository.MemberRepository;

//Spring bean에 등록
@Component
public class JoinFormValidator implements Validator{
	
	private final MemberRepository memberRepository;
	
	public JoinFormValidator(MemberRepository memberRepository) {
		super();
		this.memberRepository = memberRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// 검증할수있어?
		return clazz.equals(JoinForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		JoinForm form = (JoinForm) target;
		
		//아이디 존재유무
		if(memberRepository.selectMemberByUserId(form.getUserId()) !=null) {
			errors.rejectValue("userId", "err-userIdd", "이미 존재하는 아이디입니다"); //Errors에 담아줌
		}
		//비번 정규식
		if(!Pattern.matches("(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^a-zA-Zㄱ-힣0-9]).{8,}", form.getPassword())) {
			errors.rejectValue("password", "err-password", "비밀번호는 숫자, 영문자, 특수문자 조합의 8글자 이상인 문자열 입니다");
		}
		//전화번호 정규식
		if(!Pattern.matches("\\d{9,11}",form.getTell())){
			errors.rejectValue("tell", "err-tell", "전화번호는 9~11자리의 숫자입니다");
		}
		
		
	}

	
	
	
	
}
