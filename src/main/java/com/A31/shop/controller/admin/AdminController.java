package com.A31.shop.controller.admin;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.A31.shop.service.admin.CategoryService;
import com.A31.shop.service.admin.GoodsCategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AdminController {
	
	private final CategoryService cateService;
	
	
	////////////////////////////대시보드 관련 기능///////////////////////////////
	
	/*
	 * 관리자 대시보드 페이지
	 */
	@GetMapping("/admin")
	public String admin() {
		return "admin/dashBorad";
	}
	
	@GetMapping("admin/new-notice")
	public String newNotice() {
		return "admin/board/noticeWrite";
	}
	
	@GetMapping("admin/new-qna")
	public String newQna() {
		return "admin/board/qnaWrite";
	}
	
	@GetMapping("admin/dash")
	public String dash() {
		return "admin/board/dash";
	}
	
	@GetMapping("admin/dashBoard")
	public String dashboard() {
		return "admin/dashBoard";
	}
	
	@ResponseBody
	@GetMapping("/header")
	public Map<String, Long> header() {
		Map<String, Long> map = cateService.getList();
		return map;
	}
	
}
