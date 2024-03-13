package com.A31.shop.domain.dto;

import com.A31.shop.domain.entity.Notice;

import lombok.Getter;

@Getter
public class NoticeResponse {
	
	private final String title;
	private final String content;
	
	public NoticeResponse(Notice notice) {
		this.title=notice.getTitle();
		this.content = notice.getContent();
	}
}
