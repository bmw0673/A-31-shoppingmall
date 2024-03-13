package com.A31.shop.domain.dto;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import com.A31.shop.domain.entity.goods.GoodsEntity;

import lombok.Builder;
import lombok.Getter;
@Getter
@Builder
public class GoodsImgListDTO {
	
	private long no;
	private String bucketKey;
	private String orgName;
	private boolean thumbnail;
}
