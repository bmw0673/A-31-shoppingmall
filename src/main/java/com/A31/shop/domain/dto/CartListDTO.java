package com.A31.shop.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Builder
public class CartListDTO {
	
	private GoodsListDTO goods;
	
	private int count;
	
	
}
