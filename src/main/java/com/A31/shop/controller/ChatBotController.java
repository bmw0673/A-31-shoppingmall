package com.A31.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatBotController {
	
	@GetMapping("/chat-bot")
	public String chatbot() {
		return "yeseul/chat-bot";
	}
	
}
