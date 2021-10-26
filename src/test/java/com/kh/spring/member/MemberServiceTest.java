package com.kh.spring.member;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MemberServiceTest {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void passwordEncoderTest() {
		
		String password ="123qwe!@#";
		
		String encodedPassword = passwordEncoder.encode(password); //인코딩해줌
		logger.debug(encodedPassword);
		encodedPassword = passwordEncoder.encode(password); //한번찍어보면 다른값나옴(해시와다름)
		logger.debug(encodedPassword);
		
		logger.debug("matches :"+passwordEncoder.matches(password, encodedPassword)); //매치해서 같은지다른지 boolean
	}
	
	
}
