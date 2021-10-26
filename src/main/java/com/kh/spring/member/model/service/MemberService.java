package com.kh.spring.member.model.service;

import com.kh.spring.member.model.dto.Member;
import com.kh.spring.member.validator.JoinForm;

public interface MemberService {

	//회원가입
	public void inserMember(JoinForm form);

	//로그인유지
	public Member authenticateUser(Member member);

	public Member selectMemberByUserId(String userId);

	//이메일발송
	public void authenticateByEmail(JoinForm form, String token);
}
