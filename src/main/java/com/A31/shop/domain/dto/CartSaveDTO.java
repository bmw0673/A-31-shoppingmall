package com.A31.shop.domain.dto;

import com.A31.shop.domain.entity.MemberEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Builder
public class CartSaveDTO {
	
	private long id;
	private MemberEntity member;
	
	public CartSaveDTO  toSaveDto() {
		return CartSaveDTO.builder()
				.id(id)
				.member(member)
				.build();
	}
	 
	
}
