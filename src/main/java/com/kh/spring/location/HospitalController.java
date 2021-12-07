package com.kh.spring.location;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring.common.util.Paging;
import com.kh.spring.member.model.dto.Member;

@Controller
@RequestMapping("hospital")
public class HospitalController {
	
	@Autowired
	
	private HospitalServiceImpl hospitalService;
	@GetMapping("info")
	public String hospitalInfo() {
		return "hospital/hospital-info";
	}
	
	@GetMapping("search")
	public String searchPage() {
		return "hospital/hospital-search";
	}
	
	@GetMapping("nameSearch")
	@ResponseBody
	public List<Hospital> nameSearch(String nameinput) {
		List<Hospital> searchHospitalN = hospitalService.selectHospitalByLoName(nameinput);
		return searchHospitalN;
	}
	
	@GetMapping("localSearch")
	@ResponseBody
	public List<Hospital> localSearch(String stringAdd) {
		List<Hospital> searchHospital = hospitalService.selectHospitalByAdd(stringAdd);
		return searchHospital;
	}
	
	
	@GetMapping("detail")
	public String detail(Model model, int locationIdx) {
		Hospital hospital = hospitalService.selectHospitalByloNumber(locationIdx);
		model.addAttribute("hospital",hospital);
		return "hospital/hospital-detail";
	}
	
	
	
}
