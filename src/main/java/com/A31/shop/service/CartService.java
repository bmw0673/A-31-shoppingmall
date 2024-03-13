package com.A31.shop.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

import com.A31.shop.domain.dto.CartListDTO;

public interface CartService {

	List<CartListDTO> getCartList(Long id);

	void getCartList(Authentication auth, Model model, Long itemId);
	
	

}
