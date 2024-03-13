package com.A31.shop.controller.admin;

import java.lang.invoke.MethodHandles.Lookup.ClassOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.A31.shop.domain.dto.CompanyInfoDTO;
import com.A31.shop.naverapi.dept.DeptSaveDTO;
import com.A31.shop.service.CompanyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@RequiredArgsConstructor
@Controller
@Log4j2
@RequestMapping("/admin")
public class CompanyController {
	
	private final CompanyService companyService;
	
	
	////////////////////////////////////GET///////////////////////
	
	/*
	 * 회사관리 -> 정보수정 페이지 이동
	 */
	@GetMapping("/company")
	public String companyUpdate(Model model) {
		CompanyInfoDTO company = companyService.companyInfo();
		model.addAttribute("company", company);
		return "admin/company";
	}
	
	
	/*
	 * 부서조회 페이지 이동 
	 */
	@GetMapping("/deptList")
	public String deptList(Model model) {
		companyService.deptList(model);
		return "/admin/dept/list";
	}
	
	/*
	 * 부서등록 페이지 이동
	 */
	@GetMapping("/dept")
	public String saveDeptPage(Model model) {
		companyService.deptList(model);
		return "/admin/dept/save";
	}
	
	/////////////////////////////////////POST///////////////////////////////
	
	@PutMapping("/company/{companyId}")
	public String update(@PathVariable Long companyId, CompanyInfoDTO dto) {
		companyService.update(companyId,  dto);
		
		return "redirect:/admin/company";
	}
	
	/*
	 * 부서등록 기능
	 */
	@PostMapping("/dept")
	public String dept(DeptSaveDTO dto) {
		log.info(dto);
		companyService.saveDept(dto);
		return "redirect:/admin/deptList";
	}
	
}

