package com.A31.shop.service.amdinprocess;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.A31.shop.domain.dto.GoodsListDTO;
import com.A31.shop.domain.dto.PageRequestDTO;
import com.A31.shop.domain.dto.PageResultDTO;
import com.A31.shop.domain.entity.goods.CateEntityRepository;
import com.A31.shop.domain.entity.goods.CategoryEntity;
import com.A31.shop.domain.entity.goods.GoodsCategory;
import com.A31.shop.domain.entity.goods.GoodsCategoryRepogitory;
import com.A31.shop.domain.entity.goods.GoodsEntity;
import com.A31.shop.domain.entity.goods.GoodsEntityRepository;
import com.A31.shop.service.admin.GoodsCategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GoodsCategoryProcess implements GoodsCategoryService {

	private final GoodsCategoryRepogitory goodscateRepo;

	private final GoodsEntityRepository goodsRepo;
	
	private final CateEntityRepository cateRepo;
	/**
	 * 새로운 상품리스트 maximum 12개
	 */
	@Override
	public List<GoodsListDTO> getNewList() {

		Pageable pageable = PageRequest.of(0, 12, Direction.DESC, "createdDate");

		return goodsRepo.findAll(pageable).getContent().stream().map(GoodsEntity::toListDTO)
				.collect(Collectors.toList());

	}

	/**
	 * MD추천 상품리스트 maximum 12개
	 */
	@Override
	public List<GoodsListDTO> getMdList() {
		Pageable pageable = PageRequest.of(0, 12, Direction.DESC, "goods_createdDate");

		return goodscateRepo.findAllByCategory(CategoryEntity.builder().id(4).build(), pageable).getContent().stream()
				.map(GoodsCategory::toGoodsListDTO).collect(Collectors.toList());
	}

	/**
	 * 카테고리에 속한 상품리스트
	 */
	@Override
	public PageResultDTO<GoodsListDTO, GoodsCategory> getFindCateList(PageRequestDTO requestDTO, Long cateId) {

		Pageable pageable = requestDTO.getPageable(12, Sort.by("goods_createdDate").descending());
		
//		CategoryEntity parent = cateRepo.findById(cateId).orElseThrow().getParent();
//		Page<GoodsCategory> result = null;
//		if(parent==null) { //최상위 일시
//			CategoryEntity cate = cateRepo.findById(cateId).orElseThrow();
//			List<GoodsCategory> temp = new ArrayList<>(); 
//			for(CategoryEntity child : cate.getChild()) {
//				temp.addAll(goodscateRepo.findAllByCategory(CategoryEntity.builder().id(child.getId()).build(), pageable).getContent());
//			}
//			
//			//result = goodscateRepo.findAllByCategoryIn(temp, pageable);
//		}else { //최상위가 아닐 시
//			result = goodscateRepo.findAllByCategory(CategoryEntity.builder().id(cateId).build(), pageable);
//		}
		Page<GoodsCategory> result = goodscateRepo.findAllByCategory(CategoryEntity.builder().id(cateId).build(), pageable);
		
		Function<GoodsCategory, GoodsListDTO> fn = entity -> entity.toGoodsListDTO();

		return new PageResultDTO<>(result, fn);
	}

}
