package com.kh.spring.location;

import java.util.List;
import java.util.Map;

import com.kh.spring.common.util.Paging;

public interface HospitalService {

	public List<Hospital> selectHospitalByLoName(String nameinput);
	
	public Hospital selectHospitalByloNumber(int locationIdx);
	
	public List<Hospital> selectHospitalByAdd(String stringAdd);
	
	
}
