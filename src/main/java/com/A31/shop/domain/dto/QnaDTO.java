package com.A31.shop.domain.dto;

import com.A31.shop.domain.entity.Qna;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter

public class QnaDTO {

	private String title;
	private String content;
	
	public Qna toEntity() {
		return Qna.builder()
				.title(title)
				.content(content)
				.build();
	}
}
