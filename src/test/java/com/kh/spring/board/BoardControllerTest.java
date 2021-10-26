package com.kh.spring.board;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.kh.spring.member.model.dto.Member;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class BoardControllerTest {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(context).build();
	}

	@Test
	public void uploadBoard() throws Exception {
		
		MockMultipartFile file1 = new MockMultipartFile("files", "OFN1.txt", null, "OFN01".getBytes());
		MockMultipartFile file2 = new MockMultipartFile("files", "OFN2.txt", null, "OFN02".getBytes());
		
		Member member = new Member();
		member.setUserId("tjsdk7075");
		
		mockMvc.perform(multipart("/board/upload") //requestBuilder api검색 -->multipart사용가능
				.file(file1)
				.file(file2)
				.param("title","테테테ㅔ스스ㅡ스트트") 
				.param("content","본문")
				.sessionAttr("authentication", member))
		.andExpect(status().is3xxRedirection())
		.andDo(print());
				
	}
	
	@Test
	public void boardDetail() throws Exception{
		Member member =new Member();
		member.setUserId("tjsdk7075");
		
		mockMvc.perform(get("/board/board-detail?bdIdx=100000") //.param("bdIdx","100000")으로 넣어도됨
				.sessionAttr("authentication",member))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	
	
	
	
}
	