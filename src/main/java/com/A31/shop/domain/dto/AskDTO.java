package com.A31.shop.domain.dto;

import com.A31.shop.domain.entity.Ask;

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
	public class AskDTO {
			
			private String title;
			private String content;
			
			public Ask toEntity() {
				return Ask.builder()
						.title(title)
						.content(content)
						.build();
			}
}
