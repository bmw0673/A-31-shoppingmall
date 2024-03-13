package com.A31.shop.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;

@Getter
@MappedSuperclass
public class DateEntity {
	
	@CreationTimestamp
	@Column(columnDefinition = "timestamp(6) null")
	public LocalDateTime updatedDate;
	
	@UpdateTimestamp
	@Column(columnDefinition = "timestamp(6) null")
	public LocalDateTime createdDate;
}
