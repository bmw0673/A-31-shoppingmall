package com.A31.shop.domain.entity.goods;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.A31.shop.domain.dto.CartListDTO;
import com.A31.shop.domain.entity.MemberEntity;

public interface CartEntityRepository extends JpaRepository<CartEntity, Long>{
	//쿼리메서드 규칙에서 '_'는 내부요소
	List<CartEntity> findAllByMember_no(long id);
	
	List<CartEntity> findAllByMember(MemberEntity member);
}
