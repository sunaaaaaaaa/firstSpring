package com.kh.spring.board.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.board.model.dto.Board;
import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.service.BoardServiceImpl;
import com.kh.spring.common.util.FileDTO;
import com.kh.spring.common.util.FileUtil;
import com.kh.spring.member.model.dto.Member;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	private final BoardService boardService;

	
	
	@GetMapping("board-form")
	public void boardForm() {
		
	}
	
	@PostMapping("upload")
	public String uploadBoard(Board board, List<MultipartFile> files,@SessionAttribute("authentication")Member member) { //파일 여러개라 List
		
		board.setUserId(member.getUserId());
		boardService.insertBoard(files, board);
		return "redirect:/";
	}
	
	@GetMapping("board-detail")
	public String boardDetail(String bdIdx,Model model) {
		Map<String,Object> datas = boardService.selectBoardDetail(bdIdx);
		model.addAttribute("datas", datas); 
		return "board/board-detail";
	}
	
}
