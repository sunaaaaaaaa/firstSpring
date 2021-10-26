package com.kh.spring.mybatis;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring.member.model.dto.Member;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MybatisTest {

	@Autowired
	private MybatisRepository mybatisRepository;
	String userId = "suna";
	
	@Test
	public void selectOneTest() {
		mybatisRepository.selectPasswordByUserId(userId);
	}
	
	@Test
	public void selectOneAsDTO() {
		mybatisRepository.selectMemberById(userId);
	}
	
	@Test
	public void selectListAsMap() {
		mybatisRepository.selectRentAndMemberById(userId);
	}


	@Test
	public void selectListUsingResultMap() {
		mybatisRepository.selectRentDataByUserId(userId);
	}

	
	@Test
	public void insertWithDto() {
		Member member = new Member();
		member.setUserId("mybatis-interface");
		member.setPassword("asdhakjwhek");
		member.setEmail("ppp@ccc.com");
		member.setTell("016-894-8248");
		
		mybatisRepository.insertWithDto(member);
	}

	@Test
	public void insertWithMap() {
		Member member = new Member();
		member.setUserId("mybatis-interface");
		mybatisRepository.insertWithMap(Map.of("member", member, "title", "SpringMVC가자아 외 1권", "rentBookCnt", 2));
	}
	
	@Test
	public void delete() {
		mybatisRepository.delete("mybatis-interface");
	}
	
	@Test
	public void upadate() {
		Member member = new Member();
		member.setUserId(userId);
		member.setPassword("vasdasdasd");
		mybatisRepository.update(member);
	}
	
	@Test
	public void procedure() {
		mybatisRepository.procedure("100010");
	}
	

	   @Test
	   public void dynamicQueryIF() {
		   mybatisRepository.dynamicQueryIf(Map.of("searchType", "author", "keyword", "김애란"));
	   }
	   
	   @Test
	   public void dynamicQueryChoose() {
		   mybatisRepository.dynamicQueryChoose(Map.of("searchType", "author", "keyword", "김애란"));
	   }

	   @Test
	   public void dynamicQueryWhereAndForeachTag() {
		   String[] searchTypes = {"title","author"};
		   mybatisRepository.dynamicQueryWhereAndForeachTag(Map.of("searchTypes",searchTypes,"keyword","김애란"));
	   }
	   
	   @Test
	   public void dynamicQueryForeachTagWithList() {
		   mybatisRepository.dynamicQueryForeachTagWithList(List.of("DEV", "mybatis", "pclass"));
	   }
	   
	   @Test
	   public void dynamicQuerySetTag() {
		   Member member = new Member();
		   member.setUserId("DEV");
		   member.setPassword("00009999");
		   mybatisRepository.dynamicQuerySetTag(member);
	   }
	   
	   @Test
	   public void dynamicQueryForeachTag() {
		   
	   }
   
	
	
	
}
