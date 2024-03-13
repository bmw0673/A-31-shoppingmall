package com.A31.shop.controller.admin;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.A31.shop.domain.dto.GoodsCategorySaveDTO;
import com.A31.shop.domain.dto.GoodsImgSaveDTO;
import com.A31.shop.domain.dto.GoodsSaveDTO;
import com.A31.shop.domain.dto.PageRequestDTO;
import com.A31.shop.service.admin.GoodsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller(value = "adminGoodsController")
@RequestMapping("/admin")
public class GoodsController {
	
	private final GoodsService goodsService;

	/////////////////////////////GET//////////////////////////////////
	
	/*
	 * 상품조회 페이지 이동
	 */
	@GetMapping("/goods/list")
	public String goodsList(PageRequestDTO pageRequestDTO, Model model) {
		model.addAttribute("result", goodsService.getList(pageRequestDTO));
		return "admin/goods/list";
	}
	
	/*
	 * 상품상세 페이지 이동
	 */
	@GetMapping("/goods/{goodsId}")
	public String detail(@PathVariable Long goodsId, Model model) {
		goodsService.readGoods(goodsId, model);
		return "admin/goods/detail";
	}
	
	/*
	 * 상품등록 페이지 이동
	 */
	@GetMapping("/goods")
	public String addGoods(Model model) {
		model.addAttribute("categories", goodsService.getCategoty());
		return "admin/goods/register";
	}
	
	//////////////////////////////POST//////////////////////////////////////
	
	/*
	 * 1.상품저장 기능
	 * 2.상품테이블과 상품이미지 테이블에 저장
	 * 3.임시저장소에 저장된 사진은 삭제하고 주소를 옮김
	 */
	@PostMapping("/goods")
	public String save(GoodsSaveDTO goods, GoodsImgSaveDTO goodsImg, GoodsCategorySaveDTO goodsCate) {
		goodsService.saveProcess(goods, goodsImg, goodsCate);
		return "redirect:/admin/goods/list";
	}
	
	/*
	 * 임시저장소에 이미지 파일을 저장하고 보여준다.
	 */
	@ResponseBody
	@PostMapping("/temp-upload")
	public Map<String, String> s3fileUpload(MultipartFile goodsImg) {
		return goodsService.s3fileUploadPrecess(goodsImg);
	}
	
}