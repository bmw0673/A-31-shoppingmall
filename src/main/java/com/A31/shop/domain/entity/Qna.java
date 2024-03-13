package com.A31.shop.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.A31.shop.domain.dto.QnaDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Entity
public class Qna {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content;

	@CreationTimestamp
	private LocalDateTime createdDate;

	@UpdateTimestamp
	private LocalDateTime updatedDate;
//
//	private int readCount; // 조회수 0
//
//	boolean isLock; // 게시글잠금여부 false

	public QnaDTO toDto() {
		return QnaDTO.builder()
				.title(title)
				.content(content)
				.build();
	}
	
	public void update(String title, String content) {
		this.title=title;
		this.content=content;
	}
	
}
