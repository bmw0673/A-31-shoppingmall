package com.A31.shop.domain.entity.goods;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CateEntityRepository extends JpaRepository<CategoryEntity, Long>{

	Optional<CategoryEntity> findByName(String name);
	
}
