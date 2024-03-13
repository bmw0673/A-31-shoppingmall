package com.A31.shop.domain.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsNewDTO {
	
	private Long no;
	
	private String name;
	
	private Long price;
	
	private List<GoodsImgListDTO> imgs;
}
