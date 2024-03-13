package com.A31.shop.domain.entity.goods;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.A31.shop.domain.dto.CartListDTO;
import com.A31.shop.domain.dto.CartSaveDTO;
import com.A31.shop.domain.entity.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
@Entity
public class CartEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "goods_id")
	private GoodsEntity goods; //상품
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private MemberEntity member; //회원
	
	@Column(nullable = false)
	private int count;
	
	public CartListDTO  toListDto() {
		return CartListDTO.builder()
				.count(count)
				.goods(goods.toListDTO())
				.build();
	}

	public static CartEntity createCart(MemberEntity member) {
		CartEntity cart = new CartEntity();
        cart.member = member;
        cart.count = 0;

        return cart;

	}


	
	
}
