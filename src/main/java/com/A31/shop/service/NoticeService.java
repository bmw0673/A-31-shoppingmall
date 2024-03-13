package com.A31.shop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.A31.shop.domain.dto.NoticeDTO;
import com.A31.shop.domain.dto.UpdateNoticeRequest;
import com.A31.shop.domain.entity.Notice;
import com.A31.shop.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeService {

	private final NoticeRepository noticeRepository;

	// 공지사항 글 추가 메서드
	public Notice save(NoticeDTO dto) {
		return noticeRepository.save(dto.toEntity());
	}

	// 전체공지사항조회
	public List<Notice> findAll() {
		return noticeRepository.findAll();
	}

	
	
	
	
	// 공지사항 삭제하는 메서드
	public void delete(long id) {
		noticeRepository.deleteById(id);
	}

	// 공지사항 수정
	@Transactional
	public Notice update(long id, UpdateNoticeRequest request) {
		Notice notice = noticeRepository.	findById(id)
				.orElseThrow(() -> new IllegalArgumentException("not found:" + id));

		notice.update(request.getTitle(), request.getContent());
		return notice;
	}

	public void getList(Model model) {
		List<NoticeDTO> list = noticeRepository.findAll().stream().map(Notice::toDto).collect(Collectors.toList());
		model.addAttribute("list", list);
	}
	}
