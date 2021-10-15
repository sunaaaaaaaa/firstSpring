package com.kh.spring.member;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


//가상으로 만들어지는 web.xml을 사용해 테스트환경 구축함
@WebAppConfiguration
//JUnit을 실행할 방법
//테스트때 사용할 가상의 applicationContext를 생성하고 관리
@RunWith(SpringJUnit4ClassRunner.class)
//가상의 applicationContext생성할때 사용할 spring bean설정파일 위치를 지정
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MemberControllerTest {

	@Autowired
	WebApplicationContext context;
	
	private MockMvc mockMvc; //목객체
	
	//@Before :테스트 수행전 실행될 메소드에 선언
	//@Test : 테스트 수행할 메소드
	//After : 테스트 수행후 실행될 메소드에 선언
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void searchPassword() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/spring/search-pw"))
		.andDo(MockMvcResultHandlers.print());
	}
	
	@After
	public void afterTest() {
		System.out.println("테스트종료");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
