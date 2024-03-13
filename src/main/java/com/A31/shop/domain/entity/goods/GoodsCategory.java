package com.A31.shop.domain.entity.goods;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.A31.shop.domain.dto.CateListDTO;
import com.A31.shop.domain.dto.GoodsListDTO;
import com.A31.shop.domain.dto.GoodsMdDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "goods_category")
@Getter
public class GoodsCategory {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "goods_category_id")
	private long id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "goods_id")
	private GoodsEntity goods; //상품
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private CategoryEntity category; //카테고리
	
	public GoodsListDTO toGoodsListDTO(){
		return goods.toListDTO();
	}
	
	public CateListDTO toCateListDTO(){
		return category.toListDTO();
	}
	
	
}
