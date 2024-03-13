package com.A31.shop.domain.entity;


import java.util.Set;
import java.util.HashSet;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
@Entity
public class MemberEntity extends DateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private long no;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	
	
	
	/*
	 * UserEntity에 대응하는 권한을 나타내는 테이블을 만듬 *UserEntity내부 테이블에 생성되지 않음!!!
	 * 중복을 허용하지 않고 순서가 상관없으므로 Set Collection을 이용해서 만듬
	 */
	@Builder.Default
	@Enumerated(EnumType.STRING)  //선언하지 않으면 DB에 저장시 ordinal(숫자)로 저장됨
	@CollectionTable(name = "role")
	@ElementCollection(fetch = FetchType.EAGER)//1:n UserEntity에서만 접근가능한 내장테이블
	private Set<UserRole> userRoles = new HashSet<>();
	
	
	/*
	 * 편의메서드
	 * Service에서 회원가입시 Role을 부여하기 편하기 위한 편의메서드
	 */
	public MemberEntity addRole(UserRole role) {
		userRoles.add(role);
		return this;
	}
}
