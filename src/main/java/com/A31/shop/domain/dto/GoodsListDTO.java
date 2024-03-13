package com.A31.shop.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.A31.shop.domain.entity.goods.GoodsCategory;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class GoodsListDTO{
	
	private long no;
	private String name;
	private long price;
	private int stockQuantity;
	private String content;
	private LocalDateTime updatedDate;
	private LocalDateTime createdDate;
	
	private List<GoodsImgListDTO> imgs;
	private List<CateListDTO> categories;
	
}
