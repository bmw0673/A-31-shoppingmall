package com.A31.shop.domain.entity.goods;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Cart_itemRepository extends JpaRepository<CartEntity, Long> {

      static Cart_item findByCartIdAndItemId(long cartId, long GoodsId) {
		// TODO Auto-generated method stub
		return null;
	}

	static void save(Cart_item cart_item) {
		// TODO Auto-generated method stub
		
	}

	
}
