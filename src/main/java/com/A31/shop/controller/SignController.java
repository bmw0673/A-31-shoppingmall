package com.A31.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.A31.shop.domain.dto.MemberSaveDTO;
import com.A31.shop.service.SignService;

@Controller
public class SignController {
	
	@Autowired
	SignService service;
	
	//로그인 페이지
	@PreAuthorize("isAnonymous()")
	@GetMapping("/login") 
	public String loginPage(Authentication auth) {
		if(auth!=null)return "redirect:/?auth";
		 return "sign/login"; 
	}
	
	//회원가입 페이지
	@GetMapping("/join")
	public String join() {
		return "sign/join";
	}
	
	//회원가입 요청
	@PostMapping("/join")
	public String join(MemberSaveDTO dto) {
		service.join(dto);
		return "redirect:/";
	}
	
	
}