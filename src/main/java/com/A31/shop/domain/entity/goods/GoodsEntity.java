package com.A31.shop.domain.entity.goods;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.A31.shop.domain.dto.GoodsListDTO;
import com.A31.shop.domain.entity.DateEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "goods")
@Entity
public class GoodsEntity extends DateEntity{
	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "goods_id")
	private long no;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private long price;
	
	@Column(nullable = false)
	private int stockQuantity;
	
	@Column(nullable = false, columnDefinition = "longtext")
	private String content;
	
	
	@OneToMany(mappedBy = "goods")
	private List<GoodsImgEntity> imgs;
	
	@OneToMany(mappedBy = "goods")
	private List<GoodsCategory> categories;
	
	
	public GoodsListDTO toListDTO() {
		return GoodsListDTO.builder()
				.no(no).name(name).price(price).stockQuantity(stockQuantity)
				.createdDate(createdDate).updatedDate(updatedDate)
				.content(content)
				.imgs(getImgs().stream().filter(t -> t.isThumbnail())
						.map(GoodsImgEntity::toListDTO)
						.collect(Collectors.toList()))
				.categories(getCategories().stream()
						.map(GoodsCategory::toCateListDTO)
						.collect(Collectors.toList()))
				.build();
	}
	
	public GoodsListDTO toDetailDTO() {
		return GoodsListDTO.builder()
				.no(no).name(name).price(price).stockQuantity(stockQuantity)
				.createdDate(createdDate).updatedDate(updatedDate)
				.content(content)
				.imgs(getImgs().stream()
						.map(GoodsImgEntity::toListDTO)
						.collect(Collectors.toList()))
				.categories(getCategories().stream()
						.map(GoodsCategory::toCateListDTO)
						.collect(Collectors.toList()))
				.build();
	}
	
	
}
