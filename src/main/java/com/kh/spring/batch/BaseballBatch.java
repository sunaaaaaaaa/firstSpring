package com.kh.spring.batch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BaseballBatch {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BatchRepository batchRepository;
	
	//cron표현식을 사용한 batch프로그램
	//초 분 시 일 월 요일(0~6) 연도 (스프링에서는 사용안함)
	//* :모든
	// ,: 복수값을 지정
	//시작시간/단위 : 시작시간부터 지정한 단위마다 실행
	// 0 0 3 * * * =>매일 새벽3시에 배치 실행함
	// 0 0 3,6,22 * * *=>새벽 3시, 아침6시, 밤10시에 배치 실행함
	// 0 0/15 * * * * =>15분마다 배치 실행함
	
	@Scheduled(cron="0 50 21 10 12 *")
	public void jsoupTest3() {
		
		Elements elementList;
		try {
			elementList = Jsoup.connect("https://www.koreabaseball.com/TeamRank/TeamRank.aspx")
					.get().select("#cphContents_cphContents_cphContents_udpRecord > table > tbody > tr");
		
			List<Map<String,String>> dataList =getRankDataList(elementList);
			
			for (Map<String, String> map : dataList) {
				batchRepository.insertBaseBallRank(map);
			}
			logger.debug("배치완료");
			logger.debug("그동안 수고 많으셨습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private List<Map<String,String>> getRankDataList(Elements elementList) {
		
		String[] keyArr = {"rank","name","game","win","lose","tie"};
		List<Map<String,String>> dataList = new ArrayList<>();
		
		for (Element tr : elementList) {	
			
			Elements tdList =tr.getElementsByTag("td");
			Map<String,String> command = new HashMap<>();
			for (int i = 0; i < keyArr.length; i++) {
				Element td =tdList.get(i);
				command.put(keyArr[i], td.text());
			}
			dataList.add(command);
		} 				
		return dataList;
	}
	
	
}
