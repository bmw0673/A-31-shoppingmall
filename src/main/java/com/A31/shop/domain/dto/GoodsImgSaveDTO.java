package com.A31.shop.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class GoodsImgSaveDTO {
	private String[] tempKey;
	private String[] orgName;
}
