package com.A31.shop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.A31.shop.domain.dto.CartListDTO;
import com.A31.shop.domain.dto.CartSaveDTO;
import com.A31.shop.domain.entity.MemberEntity;
import com.A31.shop.domain.entity.MemberEntityRepository;
import com.A31.shop.domain.entity.goods.CartEntity;
import com.A31.shop.domain.entity.goods.CartEntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CartServiceProcess implements CartService  {
	private final CartEntityRepository cartRepo;
	private final MemberEntityRepository memRepo;
	
	//장바구니 만들기
	/*
	 * public Object createCart(CartSaveDTO dto){ return
	 * CartEntityRepository.save(dto.toSaveDto()); }
	 * 
	 * //장ㅂ
	 */
	
	/**
	 * 장바구니 리스트 불러오기
	 */
	@Override
	public List<CartListDTO> getCartList(Long id) {
		return null;
	}

	@Override
	public void getCartList(Authentication auth, Model model, Long goodsId) {
		if(auth==null) {
			//비회원
		}else {
			//회원
			String email=auth.getName();
			model.addAttribute("list", cartRepo.findAllByMember(memRepo.findByEmail(email).orElseThrow())
					.stream()
					.map(CartEntity::toListDto)
					.collect(Collectors.toList()));
		}
		
	}

	
}
