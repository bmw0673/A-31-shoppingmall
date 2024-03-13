package com.A31.shop.domain.entity.goods;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.A31.shop.domain.dto.CateListDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
@Entity
public class CategoryEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	
	//아래는 연관관계 매핑을 위한 구조
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "parent_id")
	private CategoryEntity parent; //부모
	
	
	@OneToMany(mappedBy = "parent")
	private List<CategoryEntity> child;
	
	//편의메서드
	public CateListDTO toListDTO() {
		return CateListDTO.builder()
				.cateId(id)
				.cateName(name)
				.build();
	}
}
