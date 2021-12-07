package com.kh.spring.location;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kh.spring.common.util.Paging;
import com.kh.spring.member.model.dto.Member;

@Mapper
public interface HospitalRepository {

	@Select("select * from hospital where BPLC_NM like '%${nameinput}%'")
	List<Hospital> selectHospitalByLoName(String nameinput);

	@Select("select * from hospital where LOCATION_IDX = ${locationIdx}")
	Hospital selectHospitalByloNumber(int locationIdx);

	@Select("select * from hospital where SITE_WHL_ADDR like '${stringAdd}%' or RDN_WHL_ADDR like '${stringAdd}%'")
	List<Hospital> selectHospitalByAdd(String stringAdd);

	@Insert("insert into hospital(LOCATION_IDX,MGT_NO,TRD_STATE_NM,SITE_TEL,SITE_WHL_ADDR,RDN_WHL_ADDR,BPLC_NM,UPDATE_DT,INDEX_X,INDEX_Y,LIND_JOB_GBN_NM,LIND_PRCB_GBN_NM)"
			+ " values(sc_hospital_idx.nextval,#{mgtNo},#{trdStateNm},#{siteTel},#{siteWhlAddr},#{rdnWhlAddr},#{bplcNm},#{updateDt},#{indexX},#{indexY},#{lindJobGbnNm},#{lindPrcbGbnNm})")
	void insertHospital(Hospital coomand);
	

	
}