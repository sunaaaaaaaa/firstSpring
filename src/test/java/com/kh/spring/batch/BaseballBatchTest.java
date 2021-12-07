package com.kh.spring.batch;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.kh.spring.member.model.dto.Member;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class BaseballBatchTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private MockMvc mockMvc;
	
	@Autowired
	private BatchRepository batchRepository;
	
	@Test
	public void jsoupTest() throws IOException {
		
		Element bodyElement = Jsoup.connect("https://comic.naver.com/webtoon/weekdayList").get().body();
		Elements aTagList = bodyElement.select("#content > div.list_area.daily_img > ul > li > div > a");
		
		for (Element element : aTagList) {
			logger.debug(element.attr("title"));
		}
		
	}
	
	@Test
	public void jsoupTest2() throws IOException {
		
		Elements bodyElement = Jsoup.connect("http://www.khoa.go.kr/oceangrid/koofs/kor/observation/obs_real_list.do")
				.get().select("li .rig_value02"); //이름만 출력
		
		for (Element element : bodyElement) {	//필요한데이터를 비동기로 데려오면 uri는 껍데기임. 
			logger.debug(element.attr("title").toString()); //콘솔에 암거도 안뜸 ->그래서 seleneum으로 크롤링 하기도함
		} 									//f12에서 네트워크로 비동기 땡겨오는 데이터를 찾으면되긴함
		
	}
	
	@Test
	public void jsoupTest3() throws IOException {
		
		Elements elementList = Jsoup.connect("https://www.koreabaseball.com/TeamRank/TeamRank.aspx")
				.get().select("#cphContents_cphContents_cphContents_udpRecord > table > tbody > tr"); 
		
		String[] keyArr = {"rank","name","game","win","lose","tie"};
		List<Map<String,String>> dataList = new ArrayList<>();
		
		for (Element tr : elementList) {	
			logger.debug(tr.toString()); 
			
			Elements tdList =tr.getElementsByTag("td");
			Map<String,String> command = new HashMap<>();
			for (int i = 0; i < keyArr.length; i++) {
				Element td =tdList.get(i);
				command.put(keyArr[i], td.text());
			}
			dataList.add(command);
		} 								
		
		for (Map<String, String> map : dataList) {
			logger.debug(map.toString());
			batchRepository.insertBaseBallRank(map);
		}
		
	}
	
	
	@Test
	public void testHospital() throws Exception{
		
		mockMvc.perform(get("http://www.localdata.go.kr/platform/rest/GR0/openDataApi?authKey=71aSN53vwWyEBUCf9mQS/i9vHgtcgy0vQaaJtzehLMo="))
		.andExpect(status().isOk())
		.andDo(print());
	}
}
