package com.A31.shop.security;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Getter;

@Getter
public class MyOAuth2User implements OAuth2User {

	private Map<String, Object> attributes;
	private Collection<? extends GrantedAuthority> authorities;
	private String email;
	private String profileImg;
	private String nickName;
	
	
	
	public MyOAuth2User(OAuth2User oAuth2User, String registrationId) {
		this.authorities=oAuth2User.getAuthorities();
		if(registrationId.equals("google")) {
			ofGoogle(oAuth2User);
		}else if(registrationId.equals("naver")) {
			ofNaver(oAuth2User);
		}else if(registrationId.equals("kakao")) {
			ofKakao(oAuth2User);
		}
	}


	private void ofKakao(OAuth2User oAuth2User) {
		this.attributes=oAuth2User.getAttribute("kakao_account");
		Map<String,String> profile=(Map<String,String>) attributes.get("profile");
		nickName=profile.get("nickname");
		profileImg=profile.get("profile_image_url");
		
	}

	private void ofNaver(OAuth2User oAuth2User) {
		this.attributes=oAuth2User.getAttribute("response");
		this.email=(String)attributes.get("email");
		this.profileImg=(String)attributes.get("profile_image");
		this.nickName=(String)attributes.get("name");
	}



	private void ofGoogle(OAuth2User oAuth2User) {
		this.attributes=oAuth2User.getAttributes();
		this.email=(String)attributes.get("email");
		//this.profileImg=(String)attributes.get("pictrue");
		this.nickName=(String)attributes.get("name");
		}



	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getName() {
		return nickName;
	}

}
