package com.A31.shop.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.A31.shop.domain.dto.AskDTO;
import com.A31.shop.domain.dto.NoticeDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Getter
public class Ask {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="akstitle")
	private String title;
	
	@Column(name="akscontent")
	private String content;
	
	public AskDTO toDto() {
		return AskDTO.builder()
				.title(title)
				.content(content)
				.build();
	}
	
	public void update(String title, String content) {
		this.title=title;
		this.content=content;
	}
}
