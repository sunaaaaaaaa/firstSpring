package com.kh.spring.common.util;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;

import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.spring.common.code.Config;

@Controller
public class FileHandler {

	@GetMapping("download")
	public ResponseEntity<UrlResource> downloadFile(FileDTO file) throws MalformedURLException, UnsupportedEncodingException{ //MalException: url잘못썻을때 던지는 exception
		
		UrlResource resource = new UrlResource(Config.DOMAIN.DESC+file.getDownloadURL());
		
		String originFileName = URLEncoder.encode(file.getOriginFileName(), "UTF-8");
		
		//요청 head만들어야해서 ResponseEntity로
		ResponseEntity<UrlResource> response = ResponseEntity.ok().header("Content-Disposition", "attachmemt; filename="+originFileName)
				.body(resource);
		
		return response;
	}
	
	
}
