package com.A31.shop.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.A31.shop.service.CartService;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Controller
public class CartController {

	private final CartService cartService;
	


	

	@GetMapping("/cart")
	public String basket(Authentication auth, Model model, Long itemId) {
		
		cartService.getCartList(auth, model, itemId);
		
		return "cart/cart";
	}
	
	@GetMapping("/myPage/main")
	public String mypage() {

		return "yeseul/mypage";
	}
}
