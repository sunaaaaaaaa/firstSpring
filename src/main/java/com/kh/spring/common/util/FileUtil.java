package com.kh.spring.common.util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.common.code.Config;
import com.kh.spring.common.code.ErrorCode;
import com.kh.spring.common.exception.HandlableException;

public class FileUtil {

	
	public FileDTO fileupload(MultipartFile mf) {
	
		FileDTO file =createFileDTO(mf);
		
		try {
			mf.transferTo(new File( getSavePath() +file.getRenameFileName()));
		} catch (IllegalStateException | IOException e) {
			throw new HandlableException(ErrorCode.FAILED_FILE_UPLOAD_ERROR,e);
		} 
		
		return file;
	}
	

	private String getSubPath() {
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int date = today.get(Calendar.DATE);
		return year + "/" + month + "/" + date + "/";
	}
	

	private String getSavePath() {
		
		String subPath = getSubPath();
		String savePath = Config.UPLOAD_PATH.DESC + subPath;
		
		File dir = new File(savePath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		return savePath;
	}
	

	private FileDTO createFileDTO(MultipartFile mf) {
		FileDTO fileDTO = new FileDTO();
		String originFileName= mf.getOriginalFilename();
		String renameFileName = UUID.randomUUID().toString();
		if(originFileName.contains(".")) { //확장자가 존재하면 (없을수도있음)
		//뒤에 확장자 짤라주기 (마지막.지점으로 잘라줌)
		renameFileName = renameFileName += originFileName.substring(originFileName.lastIndexOf("."));
		}
		String savePath = getSubPath();
		
		fileDTO.setOriginFileName(originFileName);
		fileDTO.setRenameFileName(renameFileName);
		fileDTO.setSavePath(savePath);
		return fileDTO;
	}
	
	
	
	
}
