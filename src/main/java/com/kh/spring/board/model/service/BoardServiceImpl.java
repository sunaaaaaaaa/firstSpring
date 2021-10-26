package com.kh.spring.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.board.model.dto.Board;
import com.kh.spring.board.model.repository.BoardRepository;
import com.kh.spring.common.util.FileDTO;
import com.kh.spring.common.util.FileUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{ //Impl 프록시 패턴으로 만들어줌

	private final BoardRepository boardRepository;
	
	//@Transactional 에러낫을때 board는 들어가는데 file은 안들어갈경우, 예외처리해줘야 하므로 트랜잭션관리해쥼(롤백,커밋)
	public void insertBoard(List<MultipartFile> mf,Board board) {
		
		FileUtil fileUtil = new FileUtil();
		boardRepository.insertBoard(board); 
		
		for (MultipartFile multipartFile : mf) {
			if(!multipartFile.isEmpty()) { //파일이 비어있지않다면
			boardRepository.insertFileInfo(fileUtil.fileupload(multipartFile));
			}
		}
	}
	
	public Map<String,Object> selectBoardDetail(String bdIdx){
		
		Board board =boardRepository.selectBoard(bdIdx);
		
		List<FileDTO> files = boardRepository.selectFileToBoard(bdIdx);
		
		return Map.of("board",board,"files",files);
	}
	
	
}
