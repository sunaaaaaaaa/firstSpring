package com.kh.spring.location;

import lombok.Data;

@Data
public class Hospital {
	
	private int locationIdx;
	private String mgtNo;
	private String trdStateNm;
	private String siteTel;
	private String siteWhlAddr;
	private String rdnWhlAddr;
	private String bplcNm;
	private String updateDt;
	private String indexX;
	private String indexY;
	private String lindJobGbnNm;
	private String lindPrcbGbnNm;
	
	public Hospital dataGagong(Hospital fromDB) {
		if(fromDB.getLindJobGbnNm().contains("동물판매업")) {
			fromDB.setLindJobGbnNm(fromDB.getLindJobGbnNm().replace("동물판매업", "편의시설"));
			
			int spaceCnt = 0;
			String prcb =fromDB.getLindPrcbGbnNm();
			
			for(int i=0 ; i< prcb.length(); i++) {
				if(prcb.charAt(i)== ' ') {
					spaceCnt++;
				}
			}
			for(int j=0; j <spaceCnt+1 ; j++) { //공백개수만큼
				if(prcb.contains("위탁관리")) {
					fromDB.setLindPrcbGbnNm(prcb.replace("위탁관리", "호텔"));
				}else if(prcb.contains("판매")) {
					fromDB.setLindPrcbGbnNm(prcb.replace("판매", "애견용품"));
				}else if(prcb.contains("전시")) {
					fromDB.setLindPrcbGbnNm(prcb.replace("전시", "애견카페"));
				}else if(prcb.contains("생산")) {
					fromDB.setLindPrcbGbnNm(prcb.replace("생산", "분양"));
				}else if(prcb.contains("운송")) {
					fromDB.setLindPrcbGbnNm(prcb.replace("운송", "펫택시"));
				}
				
			}
		}
		return fromDB;
	}

}
