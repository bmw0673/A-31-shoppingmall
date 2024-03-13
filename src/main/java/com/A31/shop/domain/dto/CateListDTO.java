package com.A31.shop.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CateListDTO {
	
	private Long cateId;
	
	private String cateName;
}
