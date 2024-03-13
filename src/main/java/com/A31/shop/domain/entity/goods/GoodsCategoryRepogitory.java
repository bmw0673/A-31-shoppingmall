package com.A31.shop.domain.entity.goods;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsCategoryRepogitory extends JpaRepository<GoodsCategory, Long>{

	Page<GoodsCategory> findAllByCategory(CategoryEntity build, Pageable pageable);

}
