package com.A31.shop.domain.dto;


import org.springframework.security.crypto.password.PasswordEncoder;

import com.A31.shop.domain.entity.MemberEntity;

import lombok.Setter;

@Setter
public class MemberSaveDTO {
	
	private String email;
	private String password;

	
	public MemberEntity toMemberEntity(PasswordEncoder passwordEncoder) {
		
		return MemberEntity.builder()
				.email(email)
				.password(passwordEncoder.encode(password))
				.build();
	}

}
