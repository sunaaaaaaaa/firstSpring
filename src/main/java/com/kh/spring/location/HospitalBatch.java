package com.kh.spring.location;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HospitalBatch {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	private String url = "http://www.localdata.go.kr/platform/rest/GR0/openDataApi?authKey=71aSN53vwWyEBUCf9mQS/i9vHgtcgy0vQaaJtzehLMo=&resultType=json";
	
	@Scheduled(cron="0 0 12 * * *")
	  public void getData() {
		
		Calendar calendar = Calendar.getInstance();
		String today = calendar.get(Calendar.YEAR)+"년 "+(calendar.get(Calendar.MONTH)+1)+"월 "+calendar.get(Calendar.DATE)+"일자";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		logger.debug(today+" Batch API 응답코드 : "+response.getStatusCode());
		
		try {
			List<Hospital> updateList = new ArrayList<Hospital>();
			
			 //하나씩 까줌
			 JSONParser parser = new JSONParser(); 
			 JSONObject jsonObject = (JSONObject) parser.parse(response.getBody());
			 JSONObject docuArray = (JSONObject) jsonObject.get("result");
			 JSONObject docuArray2 =(JSONObject) docuArray.get("body");
			 JSONArray docuArray3 =(JSONArray) docuArray2.get("rows");
			 JSONObject docuArray4 = (JSONObject) docuArray3.get(0); 
			 JSONArray docuArray5 =(JSONArray) docuArray4.get("row");
			 
			 for (int i = 0; i < docuArray5.size(); i++) {

				 Hospital update = new Hospital();
				 
				 JSONObject docuArray6 = (JSONObject) docuArray5.get(i); 
				 
				 String openSId = (String) docuArray6.get("opnSvcId"); 
				 String stateG = (String) docuArray6.get("trdStateGbn");
				 String updateMgtNo = ((Long)docuArray6.get("mgtNo")).toString(); 
				 String updateTrdStateNm = (String) docuArray6.get("trdStateNm"); 
				 String updateSiteTel = (String) docuArray6.get("siteTel"); 
				 String updateSiteWhlAddr = (String) docuArray6.get("siteWhlAddr"); 
				 String updateRdnWhlAddr = (String) docuArray6.get("rdnWhlAddr"); 
				 String updateBplcNm = (String) docuArray6.get("bplcNm"); 
				 String updateDate = (String) docuArray6.get("updateDt"); 
				 String updateX = (String) docuArray6.get("x"); 
				 String updateY = (String) docuArray6.get("y"); 
				 String updateLindJobGbnNm = (String) docuArray6.get("lindJobGbnNm"); 
				 String updateLlindPrcbGbnNm = (String) docuArray6.get("lindPrcbGbnNm"); 
				 
				 if(openSId.equals("02_03_06_P")||openSId.equals("02_03_01_P")||openSId.equals("02_03_02_P")) { 
					 
					 if(stateG.equals("01")) { 
						 
						 if(!updateX.equals("")) {
								 update.setMgtNo(updateMgtNo);
								 update.setTrdStateNm(updateTrdStateNm);
								 update.setSiteTel(updateSiteTel);
								 update.setSiteWhlAddr(updateSiteWhlAddr);
								 update.setRdnWhlAddr(updateRdnWhlAddr);
								 update.setBplcNm(updateBplcNm);
								 update.setUpdateDt(updateDate);
								 update.setIndexX(updateX.trim());
								 update.setIndexY(updateY.trim());
								 update.setLindJobGbnNm(updateLindJobGbnNm);
								 update.setLindPrcbGbnNm(updateLlindPrcbGbnNm);
								 updateList.add(update);
							}
					 }
				 }
			}
			 logger.info(today+" 업데이트 개수 : "+updateList.size()+"건");
			 logger.info(today+" 업데이트 내용 : ");
			 for (int i = 0; i < updateList.size(); i++) {
				 hospitalRepository.insertHospital(updateList.get(i));
			 }
			 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
	

		   
			

		
	}
	
	  
}
