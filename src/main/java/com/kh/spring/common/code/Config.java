package com.kh.spring.common.code;

public enum Config {
	
	//DOMAIN("http://www.pclass.com"),
	DOMAIN("http://localhost:9191"),
	SMTP_AUTHENTICATION_ID("tjsdk7075@gmail.com"),
	SMTP_AUTHENTICATION_PASSWORD("1234"),
	COMPANY_EMAIL("tjsdk7075@gmail.com"),
	//UPLOAD_PATH("C:\\CODE\\after\\upload\\"); 운영서버
	UPLOAD_PATH("C:\\CODE\\upload\\"); //개발서버
	
	
	public final String DESC;
	
	private Config(String desc) {
		this.DESC = desc;
	}	

}
