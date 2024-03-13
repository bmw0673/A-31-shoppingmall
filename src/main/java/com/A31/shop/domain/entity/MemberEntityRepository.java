package com.A31.shop.domain.entity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//회원가입
public interface MemberEntityRepository extends JpaRepository<MemberEntity, Long> {

	//로그인 요청

	Optional<MemberEntity>findByEmail(String email);

}
