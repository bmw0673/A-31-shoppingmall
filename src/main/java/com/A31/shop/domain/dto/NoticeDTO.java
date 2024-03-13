package com.A31.shop.domain.dto;


import com.A31.shop.domain.entity.Notice;

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
public class NoticeDTO {
		
		private String title;
		private String content;
		
		public Notice toEntity() {
			return Notice.builder()
					.title(title)
					.content(content)
					.build();
		}
}
