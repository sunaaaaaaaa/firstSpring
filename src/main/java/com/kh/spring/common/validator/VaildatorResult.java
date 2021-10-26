package com.kh.spring.common.validator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

public class VaildatorResult { //회원가입시 발생한 validator실패한 값들
	
	private Map<String,Object> error;
	
	public VaildatorResult() {
		error = new HashMap<>();
	}
	
	//추가
	public void addErrors(Errors errors) {	
		Set set = new HashSet<>();
		for (FieldError filedError : errors.getFieldErrors()) {
			error.put(filedError.getField(),filedError.getDefaultMessage()); //지금은 쓸필요업지만 나중에 쓰일값을 Object value값에 넣어줌..
		}
	}
	
	//getter로사용(필요할때 쓸라고)
	public Map<String,Object> getError(){
		return error;
	}
	

}
