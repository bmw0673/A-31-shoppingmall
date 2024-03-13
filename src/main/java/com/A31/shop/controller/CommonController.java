package com.A31.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.A31.shop.service.CompanyService;
import com.A31.shop.service.admin.GoodsCategoryService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class CommonController {
	
	private final GoodsCategoryService godscateService;
	
	private final CompanyService companyService;
	
	/*
	 * DB에 있는 회사정보를 footer영역에 보여줌
	 */
	@ResponseBody
	@GetMapping("/footer")
	public ModelAndView footerInfo(ModelAndView mv) {
		
		companyService.footerInfo(mv);
		
		return mv;
	}
	/*
	 * 인덱스 페이지 이동
	 */
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("mdList", godscateService.getMdList());
		model.addAttribute("newList", godscateService.getNewList());
		return "index";
	}
}
