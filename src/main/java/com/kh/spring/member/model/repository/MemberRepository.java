package com.kh.spring.member.model.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

	@Autowired
	private SqlSessionTemplate session;
	
	public String getPassword(String userId) { //mybatisMapper.xml의 ${}안의 매개변수와 같아야함
		return session.selectOne("com.kh.spring.mybatis.MybatisMapper.selectPasswordByUserId",userId);
	}

}
