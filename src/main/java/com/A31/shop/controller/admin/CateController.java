package com.A31.shop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.A31.shop.domain.dto.CateSaveDTO;
import com.A31.shop.service.admin.CategoryService;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class CateController {
	
	private final CategoryService catecategoryService;
	
	
	@GetMapping("/category")
	public String catePage(Model model) {
		catecategoryService.getList(model);
		return "admin/category";
	}
	
	@PostMapping("/category")
	public String save(CateSaveDTO dto) {
		catecategoryService.save(dto);
		
		return "redirect:/admin/category";
	}
}
