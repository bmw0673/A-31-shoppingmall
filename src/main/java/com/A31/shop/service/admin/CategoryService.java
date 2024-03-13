package com.A31.shop.service.admin;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.A31.shop.domain.dto.CateListDTO;
import com.A31.shop.domain.dto.CateSaveDTO;

public interface CategoryService {
	
	/**
	 * 카테고리저장
	 * @param dto
	 */
	void save(CateSaveDTO dto);

	
	/**
	 * index page header category list
	 * @return Map(name, id)
	 */
	Map<String, Long> getList();


	void getList(Model model);


	List<CateListDTO> getCatechild(Long cateId);


	CateListDTO getList(Long cateId);


	CateListDTO getparent(Long cateId);
	
}
