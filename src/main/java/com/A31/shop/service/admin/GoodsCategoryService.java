package com.A31.shop.service.admin;

import java.util.List;

import com.A31.shop.domain.dto.GoodsListDTO;
import com.A31.shop.domain.dto.GoodsMdDTO;
import com.A31.shop.domain.dto.GoodsNewDTO;
import com.A31.shop.domain.dto.PageRequestDTO;
import com.A31.shop.domain.dto.PageResultDTO;
import com.A31.shop.domain.entity.goods.GoodsCategory;
import com.A31.shop.domain.entity.goods.GoodsEntity;

public interface GoodsCategoryService {

	List<GoodsListDTO> getNewList();

	List<GoodsListDTO> getMdList();
	

	/**
	 * 카테고리에 속한 상품리스트
	 */
	PageResultDTO<GoodsListDTO, GoodsCategory> getFindCateList(PageRequestDTO requestDTO, Long cateId);

}
