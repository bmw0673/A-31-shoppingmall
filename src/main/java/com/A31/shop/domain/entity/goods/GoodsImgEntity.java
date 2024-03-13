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

import com.A31.shop.domain.dto.GoodsImgListDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GoodsImg")
@Entity
public class GoodsImgEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "goods_img_id")
	private long no;
	
	@Column(nullable = false)
	private String bucketKey;
	@Column(nullable = false)
	private String orgName;
	
	private boolean thumbnail; //대표이미지 여부
	
	
	public GoodsImgListDTO toListDTO() {
		return GoodsImgListDTO.builder()
				.bucketKey(bucketKey).orgName(orgName).no(no)
				.thumbnail(thumbnail)
				.build();
	}
	
	@JoinColumn(name = "goods_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private GoodsEntity goods;
	
	
	
};