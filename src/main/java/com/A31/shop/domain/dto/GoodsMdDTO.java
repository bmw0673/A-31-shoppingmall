package com.A31.shop.domain.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GoodsMdDTO {
	
	private Long no;
	
	private String name;
	
	private Long price;
	
	private List<GoodsImgListDTO> imgs;
	
}
