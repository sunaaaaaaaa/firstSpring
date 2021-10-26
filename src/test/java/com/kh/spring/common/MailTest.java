package com.kh.spring.common;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Map;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MailTest {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//의존성주입
	@Autowired
	JavaMailSender mailSender;
	@Autowired
	RestTemplate restTemplate;
	
	
	@Test
	public void sendMail() throws MessagingException {
		
		MimeMessage msg = mailSender.createMimeMessage();
        msg.setFrom("tjsdk7075@gmail.com");
        msg.setRecipients(Message.RecipientType.TO,"tjsdk7075@gmail.com"); //받는사람
        msg.setSubject("메일테스트");
        msg.setSentDate(new Date());
        msg.setText("<h1>이메일테스트</h1>","utf-8","html");
		
        mailSender.send(msg);
	}
	
	//get방식
	@Test
	public void restTemplateGetTest() throws URISyntaxException, JsonMappingException, JsonProcessingException {
		String naveIndex = restTemplate.getForObject("https://www.naver.com", String.class);
		
		HttpHeaders header = new HttpHeaders(); 
		header.add("Authorization", "KakaoAK 56a6b7c236bf6f7c6f45c28d13247617"); 									//web에서 java검색
		RequestEntity request = RequestEntity.get("https://dapi.kakao.com/v2/search/web?query=java")
				.headers(header)
				.build();
		
		Map<String,String> obj =restTemplate.exchange(request, Map.class).getBody();
		logger.debug(obj.toString());
		
		//json방식
		String obj2 =restTemplate.exchange(request, String.class).getBody();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(obj2);
		
		for (JsonNode jsonNode : root.findValue("url")) { //url만검색
			logger.debug(jsonNode.asText()); 
		}
		
		
	}
	
	//post방식
	@Test
	public void restTemplatePostTest() throws URISyntaxException, JsonMappingException, JsonProcessingException {

		HttpHeaders header = new HttpHeaders(); 
		header.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		header.add("X-Naver-Client-Id", "qsovEEb2BjadpWzOUbKW");
		header.add("X-Naver-Client-Secret", "zvlIJKv6ZQ");
		
		MultiValueMap<String,String> body = new LinkedMultiValueMap<>();
		body.add("source", "ko");
		body.add("target", "en");
		body.add("text", "여러분들은 모두 마소 가세요?");
		
		RequestEntity<MultiValueMap> request = RequestEntity
				.post("https://openapi.naver.com/v1/papago/n2mt") //파파고번역
				.headers(header)
				.body(body);
		
		//json방식
		String obj =restTemplate.exchange(request, String.class).getBody();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(obj);
		
		for (JsonNode jsonNode : root.findValues("translatedText")) { //찾을값
			logger.debug(jsonNode.asText()); 
			}
		 
	}
	
}
