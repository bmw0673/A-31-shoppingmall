package com.A31.shop.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.A31.shop.domain.dto.NoticeDTO;
import com.A31.shop.domain.dto.QnaDTO;
import com.A31.shop.domain.dto.UpdateNoticeRequest;
import com.A31.shop.domain.entity.Notice;
import com.A31.shop.domain.entity.Qna;
import com.A31.shop.repository.QnaRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class QnaService {

	private final QnaRepository qnaRepository;

	//qna 글 추가 메서드
	public void save(QnaDTO dto) {
		qnaRepository.save(dto.toEntity());
	}
	
	//전제 qna 조회하는 메서드
	public List<Qna> findAll() {
		return qnaRepository.findAll();
	}
	
	//no를통해 하나 조회하는 메서드
	public Qna findById(Long no) {
		return qnaRepository.findById(no)
				.orElseThrow(() -> new IllegalArgumentException("not found:" + no));
	}
	
	//공지사항 삭제하는 메서드
	public void delete(long id) {
		qnaRepository.deleteById(id);
	}
	
	//qna 수정
	@Transactional
	public Qna update(long no, UpdateNoticeRequest request) {
		Qna qna = qnaRepository.findById(no)
				.orElseThrow(() -> new IllegalArgumentException("not found:" + no));
		
		qna.update(request.getTitle(), request.getContent());
		return qna;
	}
	
	//qna 전체목록가져오는 메서드
	public void getList(Model model) {
		List<QnaDTO> list = qnaRepository.findAll().stream()
				.map(Qna::toDto)
				.collect(Collectors.toList());
		model.addAttribute("qnalist", list);
	}
	
}
