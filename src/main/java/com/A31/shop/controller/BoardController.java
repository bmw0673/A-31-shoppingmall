package com.A31.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.A31.shop.domain.dto.AskDTO;
import com.A31.shop.domain.dto.CateSaveDTO;
import com.A31.shop.domain.dto.NoticeDTO;
import com.A31.shop.domain.dto.NoticeResponse;
import com.A31.shop.domain.dto.QnaDTO;
import com.A31.shop.domain.entity.Notice;
import com.A31.shop.service.AskService;
import com.A31.shop.service.NoticeService;
import com.A31.shop.service.QnaService;

@Controller
public class BoardController {

	@Autowired
	public NoticeService noticeService;

	@Autowired
	public QnaService qnaService;
	
	@Autowired
	public AskService askService;
	
	@GetMapping("write")
	public String write() {
		return "board/write";
	}
	// user 1:1문의 저장
	@PostMapping("/write") 
	public String save(AskDTO dto) {
	askService.save(dto);
	return "redirect:/";
	}
	
	// 관리자 공지사항 저장
	@PostMapping("/admin/notice")
	public String save(NoticeDTO dto) {
		noticeService.save(dto);
		return "redirect:/";
	}
	// 관리자 자주묻는 질문 저장
	@PostMapping("/admin/qna")
	public String save(QnaDTO dto) {
		qnaService.save(dto);
		return "/board/notice_2";
	}
	
	/*
	 * @PostMapping("/onebyone") public String onebyone(Model model) {
	 * askService.getList(model); return "board/onebyone"; }
	 */

	// notice페이지 열 때 db의 공지사항 전부 가져와서 화면에뿌리기
	@GetMapping("/notice")
	public String notice(Model model) {
		noticeService.getList(model);
		return "board/notice";
	}
	
	//qna페이지 열 때 db의 qna 전부 가져와서 화면에뿌리기
	@GetMapping("/notice_2")
	public String Qna(Model model) {
		qnaService.getList(model);
		return "board/notice_2";
	}
	
	// onebyone페이지 문의사항 불러와서 보여주기
	@GetMapping("/onebyone")
	public String Ask(Model model) {
		askService.getList(model);
		return "board/onebyone";
	}
	// 특정 id로 notice찾기
	@GetMapping("/notice/{id}")
	public String noticeid(@PathVariable("id") Long id) {
		return "board/id";
	}
	
	// 특정 id로 qna 찾기
		@GetMapping("/qna/{id}")
		public String qnaid(@PathVariable("id") Long id) {
			return "board/qna";
		}

	// 특정 id로 공지사항 삭제
	@PostMapping("/notice/{id}")
	public String deleteNotice(@PathVariable("id") long id) {
		System.out.println(">>삭제할pk:" + id);
		noticeService.delete(id);
		return "redirect:/notice";
	}
	
	// 특정 id로 qna 삭제
		@DeleteMapping("/qna/{id}")
		public String deleteQna(@PathVariable long id) {
			System.out.println(">>삭제할pk:" + id);
			qnaService.delete(id);
			return "rddirect:/qna";
		}
	


	
}