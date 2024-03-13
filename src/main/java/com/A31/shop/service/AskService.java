package com.A31.shop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.A31.shop.domain.dto.AskDTO;
import com.A31.shop.domain.dto.NoticeDTO;
import com.A31.shop.domain.entity.Ask;
import com.A31.shop.domain.entity.Notice;
import com.A31.shop.repository.AskRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AskService {

	@Autowired
	private final AskRepository aksRepository;
	
	public void getList(Model model) {
	List<AskDTO> list = aksRepository.findAll().stream()
			.map(Ask::toDto).collect(Collectors.toList());
	model.addAttribute("asklist", list);
	}
	public Ask save(AskDTO dto) {
		return aksRepository.save(dto.toEntity());
	}
}
