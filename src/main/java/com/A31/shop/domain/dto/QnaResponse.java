package com.A31.shop.domain.dto;

import com.A31.shop.domain.entity.Qna;

import lombok.Getter;
@Getter
public class QnaResponse {

	private final String title;
	private final String content;
	
	public QnaResponse(Qna qna) {
		this.title=qna.getTitle();
		this.content = qna.getContent();
	}
}
