package com.A31.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	
	
	
	@GetMapping("/notice")
	public String notice() {

		return "board/notice";
	}
	
	@GetMapping("/review")
	public String review() {

		return "board/review";
	}
	
	@GetMapping("/onebyone")
	public String onebyone() {

		return "board/onebyone";
	}
	
	@GetMapping("/notice_2")
	public String notice_2() {

		return "board/notice_2";
	}
}
