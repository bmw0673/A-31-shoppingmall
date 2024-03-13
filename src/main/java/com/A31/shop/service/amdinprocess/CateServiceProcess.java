package com.A31.shop.service.amdinprocess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.A31.shop.domain.dto.CateListDTO;
import com.A31.shop.domain.dto.CateSaveDTO;
import com.A31.shop.domain.entity.goods.CateEntityRepository;
import com.A31.shop.domain.entity.goods.CategoryEntity;
import com.A31.shop.service.admin.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CateServiceProcess implements CategoryService {

	private final CateEntityRepository repository;

	/**
	 * 카테고리 저장
	 */
	@Override
	public void save(CateSaveDTO dto) {
		
		CategoryEntity category = null;
		
		if(dto.getParentId() != null ) {
			CategoryEntity parnetCategory = repository.findById(dto.getParentId()).get();
			
			category = CategoryEntity.builder()
					.name(dto.getCategoryName())
					.parent(parnetCategory)
					.build();
		}else {
			category = CategoryEntity.builder()
					.name(dto.getCategoryName())
					.build();
		}
		
		repository.save(category);
	}

	/**
	 * index page header category list
	 */
	public Map<String, Long> getList() {
		return repository.findAll().stream().filter(i -> i.getParent()==null)
		.collect(Collectors.toMap(CategoryEntity::getName, CategoryEntity::getId));		
	}
	
	/**
	 * 관리자페이지 카테고리 리스트 불러오기
	 */
	@Override
	public void getList(Model model) {
		List<CateListDTO> list = repository.findAll().stream()
					.map(CategoryEntity::toListDTO)
					.collect(Collectors.toList());
		
		model.addAttribute("list", list);
		
	}

	/**
	 * 하위 카테고리 불러오기
	 */
	@Override
	public List<CateListDTO> getCatechild(Long cateId) {
		CategoryEntity parent = repository.findById(cateId).orElseThrow();
		
		List<CateListDTO> list = repository.findAll().stream()
				.filter(i -> i.getParent()==parent)
				.map(CategoryEntity::toListDTO)
				.collect(Collectors.toList());
		
		return list;
	}
	
	/**
	 * 카테고리 정보 불러오기
	 */
	@Override
	public CateListDTO getList(Long cateId) {
		return repository.findById(cateId).orElseThrow().toListDTO();
	}

	/**
	 * 부모 카테고리 불러오기
	 * 1, 2차 계층형 까지만 가능 3차계층 이후부터는 코드수정 요함.
	 */
	@Override
	public CateListDTO getparent(Long cateId) {
		CategoryEntity cate = repository.findById(cateId).orElseThrow();
		CategoryEntity parent = repository.findById(cateId).orElseThrow().getParent();
		if(parent==null) { 
			return cate.toListDTO();
		} 
		return parent.toListDTO();
	}

}
