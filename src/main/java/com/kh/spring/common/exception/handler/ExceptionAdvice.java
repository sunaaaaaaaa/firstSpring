package com.kh.spring.common.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kh.spring.common.exception.HandlableException;

@Component
@ControllerAdvice(basePackages="com.kh.spring") //ControllerAdvice는 주로 클래스에서 공통적으로 사용할수있어야하므로 Exception에서 마니 사용함 (컨트롤러랑 비슷함)
public class ExceptionAdvice {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//Handlebe예외 발생했을때 여기로 넘겨줌
	//예외가 발생했음으로 응답상태코드를 500번으로 지정, defalut는 200
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR) //이게 500번
	@ExceptionHandler(HandlableException.class) //handlabeException을 던졌을때만 ->안그럼 모든예외발생시 호출하므로
	public String handlableExceptionProcess(HandlableException e,Model model) {
		model.addAttribute("msg", e.error.MESSAGE);
		model.addAttribute("url", e.error.URL);
		return "common/result"; //에러시 result페이지로 보내줌
	}
	
	//DataBase시 처리할 예외
	@ResponseStatus(code=HttpStatus.BAD_REQUEST) //400번
	@ExceptionHandler(DataAccessException.class)
	public String dataAccessExceptionProcess(DataAccessException e,Model model) {
		e.printStackTrace();
		model.addAttribute("msg", "데이터베이스 접근 중 예외가 발생");
		model.addAttribute("url", "/"); //데이터베이스 접근하면 index로 넘겨줌
		return "common/result";
	}
	
	
}
