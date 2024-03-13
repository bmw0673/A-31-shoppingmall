package com.A31.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.A31.shop.domain.dto.PageRequestDTO;
import com.A31.shop.domain.entity.goods.CateEntityRepository;
import com.A31.shop.domain.entity.goods.CategoryEntity;
import com.A31.shop.domain.entity.goods.GoodsEntityRepository;
import com.A31.shop.service.admin.CategoryService;
import com.A31.shop.service.admin.GoodsCategoryService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class GoodsController {
	
	private final GoodsEntityRepository goodsRepo;
	
	private final GoodsCategoryService goodscateService;
	
	private final CategoryService cateService;
	
	/**
	 * 상품상세 페이지 이동
	 * @param model
	 * @param id : 상품 아이디
	 * @return
	 */
	@GetMapping("/goods/{id}")
	public String goodsDetail(Model model, @PathVariable(name = "id") Long id) {
		model.addAttribute("goods", goodsRepo.findById(id).get());
		return "goods/detail";
	}
	/**
	 * 상품 리스트 페이지 이동
	 * @param model
	 * @param cateId : 카테고리 아이디
	 * @param requestDTO : 페이징
	 * @return
	 */
	@GetMapping("/goods/list")
	public String goodsList(Model model, @RequestParam(name = "cateId") Long cateId, PageRequestDTO requestDTO) {
		model.addAttribute("cateIdParent", cateService.getparent(cateId));
		model.addAttribute("cateIdChild", cateService.getCatechild(cateService.getparent(cateId).getCateId()));
		model.addAttribute("list", goodscateService.getFindCateList(requestDTO, cateId));
		model.addAttribute("cate", cateService.getList(cateId));
		return "goods/list";
	}
}
