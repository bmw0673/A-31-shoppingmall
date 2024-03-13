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

import com.A31.shop.domain.entity.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart_item")
@Entity
public class Cart_item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cart_name")
	private CartEntity cart;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "goods_id")
	private GoodsEntity goods; //상품
	
	@Column(nullable = false)
	private int count;

	public static Cart_item createCartItem(CartEntity cart, GoodsEntity goods, int count){
		 Cart_item cartItem = new Cart_item();
	     cartItem.setCart(cart);
	     cartItem.setGoods(goods);
	     cartItem.setCount(count);

	        return cartItem;
	    }
	
	 public void addCount(int count){
	        this.count += count;
	    }
	}
	

