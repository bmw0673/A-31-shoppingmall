package com.A31.shop.domain.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.A31.shop.domain.entity.goods.CateEntityRepository;
import com.A31.shop.domain.entity.goods.CategoryEntity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class CateSaveDTO {
	
	private String categoryName;
	
	private Long parentId;

}