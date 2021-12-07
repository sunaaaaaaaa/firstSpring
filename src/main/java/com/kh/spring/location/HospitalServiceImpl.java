package com.kh.spring.location;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.stereotype.Service;

import com.kh.spring.common.util.Paging;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl{
	
	private final HospitalRepository hospitalRepository;

	public List<Hospital> selectHospitalByLoName(String nameinput) {
		List<Hospital> add = hospitalRepository.selectHospitalByLoName(nameinput);
		Hospital hos = new Hospital();
		List<Hospital> result = new ArrayList<>();
		for (Hospital hospital : add) {
			result.add(hos.dataGagong(hospital));
		}
		return result;
	}

	public Hospital selectHospitalByloNumber(int locationIdx) {
		
		Hospital re = hospitalRepository.selectHospitalByloNumber(locationIdx);
		Hospital hos = new Hospital();
		Hospital rr= hos.dataGagong(re);
		return rr;
	}

	public List<Hospital> selectHospitalByAdd(String stringAdd) {
		
		List<Hospital> add = hospitalRepository.selectHospitalByAdd(stringAdd);
		Hospital hos = new Hospital();
		List<Hospital> result = new ArrayList<>();
		for (Hospital hospital : add) {
			result.add(hos.dataGagong(hospital));
		}
		return result;
	}
	
	
	
	
}
