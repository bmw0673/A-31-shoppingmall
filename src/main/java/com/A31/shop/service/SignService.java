package com.A31.shop.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.A31.shop.domain.dto.MemberSaveDTO;
import com.A31.shop.domain.entity.MemberEntityRepository;
import com.A31.shop.domain.entity.UserRole;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SignService {

	private final MemberEntityRepository repo;

	private final PasswordEncoder passwordEncoder;
	
	//회원가입
	public void join(MemberSaveDTO dto) {
		repo.save(dto.toMemberEntity(passwordEncoder).addRole(UserRole.USER));
	}
	 
}
