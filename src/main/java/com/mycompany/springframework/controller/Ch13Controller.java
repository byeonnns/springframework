package com.mycompany.springframework.controller;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.springframework.dto.Ch13Board;
import com.mycompany.springframework.dto.Ch13Pager;
import com.mycompany.springframework.service.Ch13Service;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/ch13")
public class Ch13Controller {
	// Service 객체 주입받기
	@Autowired
	private Ch13Service service;
	
	@GetMapping("/writeBoardForm")
	public String writeBoardForm() {
		return "ch13/writeBoardForm";
	}
	
	@PostMapping("/writeBoard")
	public String writeBoard(Ch13Board board) {
		
		// 요청 데이터의 유효성 검사
		log.info("original filename : " + board.getBattach().getOriginalFilename());
		log.info("file type : " + board.getBattach().getContentType());
		
		// 첨부 파일이 있는지 조사
		if (board.getBattach() != null && !board.getBattach().isEmpty()) {
			// DTO에 추가 설정
			board.setBattachoname(board.getBattach().getOriginalFilename());
			board.setBattachtype(board.getBattach().getContentType());
			try {
				board.setBattachdata(board.getBattach().getBytes());
			} catch (Exception e) {}
		}
		
		// 로그인된 사용자 아이디 설정
		board.setMid("user");

		// 비즈니스 로직 처리를 서비스로 위임
		service.boardWrite(board);
		
		return "redirect:/ch13/boardList";	
	}
	
	@GetMapping("/boardList")
	public String boardList(String pageNo, Model model, HttpSession session) {
		
		// pageNo를 받지 못 했을 경우, 세션에 저장되어 있는지 확인
		if (pageNo == null) {
			pageNo = (String) session.getAttribute("pageNo");
			// 세션에도 저장되어 있지 않으면 기본값을 1로 세팅
			if (pageNo == null) {
				pageNo = "1";
			}
		}
		
		// 세션에 pageNo 저장
		session.setAttribute("pageNo", pageNo);

		// 문자열을 정수로 변환
		int intPageNo = Integer.parseInt(pageNo);
		
		// Pager 객체 생성
		int rowsPagingTarget = service.getTotalRows();
		Ch13Pager pager = new Ch13Pager(10, 10, rowsPagingTarget, intPageNo);
		
		// Service에서 게시물 목록 요청
		List<Ch13Board> boardList = service.getBoardList(pager);
		
		// JSP에서 이용할 수 있도록 설정
		model.addAttribute("pager", pager);
		model.addAttribute("boardList", boardList);

		return "ch13/boardList";
	}
	
	@GetMapping("/detailBoard")
	public String detailBoard(int bno, Model model) {
		Ch13Board board = service.getBoard(bno);
		model.addAttribute("board", board);
		return "ch13/detailBoard";
	}
	
	@GetMapping("/attachDownload")
	public void attachDownload(int bno, HttpServletResponse response) throws Exception {
		// 다운로드할 데이터를 준비
		Ch13Board board = service.getBoard(bno);
		
		byte[] data = service.getAttachData(bno);
		
		// 응답 헤더 구성
		response.setContentType(board.getBattachtype());
		String filename = new String(board.getBattachoname().getBytes("UTF-8"), "ISO-8859-1");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
		
		// 응답 본문에 파일 데이터 출력
		OutputStream os = response.getOutputStream();
		os.write(data);
		os.flush();
		os.close();
	}
	
	@GetMapping("/updateBoardForm")
	public String updateBoardForm(int bno, Model model) {
		Ch13Board board = service.getBoard(bno);
		model.addAttribute("board", board);
		return "ch13/updateBoardForm";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Ch13Board board) {
		
		// 첨부 파일이 있는지 조사
		if (board.getBattach() != null && !board.getBattach().isEmpty()) {
			// DTO에 추가 설정
			board.setBattachoname(board.getBattach().getOriginalFilename());
			board.setBattachtype(board.getBattach().getContentType());
			try {
				board.setBattachdata(board.getBattach().getBytes());
			} catch (Exception e) {}
		}
		
		// 비즈니스 로직 처리를 서비스로 위임
		service.updateBoard(board);
		
		return "redirect:/ch13/detailBoard?bno=" + board.getBno();
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(int bno) {
		service.removeBoard(bno);
		return "redirect:/ch13/boardList";
	}
}
