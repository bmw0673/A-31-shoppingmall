package com.A31.shop.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.A31.shop.domain.dto.NoticeDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Entity
public class Notice {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(nullable = false)
		private String title;

		@Column(nullable = false, columnDefinition = "longtext")
		private String content;

		@CreationTimestamp
		private LocalDateTime createdDate;

		@UpdateTimestamp
		private LocalDateTime updatedDate;

//		private int readCount; // 조회수 0
//
//		boolean isLock; // 게시글잠금여부 false

		public NoticeDTO toDto() {
			return NoticeDTO.builder()
					.title(title)
					.content(content)
					.build();
		}
		
		public void update(String title, String content) {
			this.title=title;
			this.content=content;
		}
}
