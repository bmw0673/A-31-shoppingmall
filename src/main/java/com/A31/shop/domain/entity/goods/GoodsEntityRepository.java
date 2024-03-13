package com.A31.shop.domain.entity.goods;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.A31.shop.domain.dto.GoodsRemoveDTO;

public interface GoodsEntityRepository extends JpaRepository<GoodsEntity, Long> {


}
