package com.A31.shop.service.admin;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.A31.shop.domain.dto.GoodsCategorySaveDTO;
import com.A31.shop.domain.dto.GoodsImgSaveDTO;
import com.A31.shop.domain.dto.GoodsListDTO;
import com.A31.shop.domain.dto.GoodsSaveDTO;
import com.A31.shop.domain.dto.PageRequestDTO;
import com.A31.shop.domain.dto.PageResultDTO;
import com.A31.shop.domain.entity.goods.CategoryEntity;
import com.A31.shop.domain.entity.goods.GoodsEntity;

public interface GoodsService {
	
	/**
	 * 상품저장 페이지에서 임시 이미지 저장
	 *  - 이미지를 올려둘시 S3에 임시로 temp 경로로 저장되고 화면에 보여준다.
	 * @param goodsImg
	 * @return
	 */
	Map<String, String> s3fileUploadPrecess(MultipartFile goodsImg);
	
	/**
	 * 상품저장
	 * @param goods : 상품정보
	 * @param goodsImg : 상품정보 이미지 
	 */
	void saveProcess(GoodsSaveDTO goods, GoodsImgSaveDTO goodsImg, GoodsCategorySaveDTO goodsCate);
	
	
	/**
	 * 상품조회
	 * @param requestDTO
	 * @return 
	 */
	PageResultDTO<GoodsListDTO, GoodsEntity> getList(PageRequestDTO requestDTO);

	
	/**
	 * 상품저장 페이지
	 * @return 카테고리 목록
	 */
	List<CategoryEntity> getCategoty();

	/**
	 * 상품상세 페이지 데이터
	 * @param goodsId : 상품 기본키
	 * @param model
	 */
	void readGoods(Long goodsId, Model model);

	
}
