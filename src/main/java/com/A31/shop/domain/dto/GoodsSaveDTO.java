package com.A31.shop.domain.dto;



import com.A31.shop.domain.entity.goods.GoodsEntity;

import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class GoodsSaveDTO {
	
	private String name;
	private long price;
	private int stockQuantity;
	private String content;
	
	public GoodsEntity toEntity() {
		return GoodsEntity.builder()
				.name(name)
				.price(price)
				.content(content)
				.stockQuantity(stockQuantity)
				.build();
	}
	
}
