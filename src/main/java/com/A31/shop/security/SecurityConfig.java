package com.A31.shop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;import com.A31.shop.service.CompanyService;

@EnableWebSecurity
public class SecurityConfig {
	
	/*
	 * 패스워드 저장시 암호화를 해주는 메서드
	 * 회원가입 Service에서 사용 할 수 있도록 Bean에 등록
	 * return 객체에 있는 생성자는 강도를 나타냄 Spring.io에서는 10 이상을 권장 
	 */
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(14);
	}
	
	/*
	 * 로그인 시 입력한 username이 DB에 있는 username과 같은지 인증하는 메서드
	 * DB에 같은 username이 있다면 DB에서 해당하는 객체를 생성(username, password, roll)하고 반환
	 */
	@Bean 
	UserDetailsService userDetailsService() { return new MyUserDetailsService(); }
	
	
	/* 
	 * .authorizeHttpRequests를 통해서 인증없이 접근할 수 있는 페이지, css, js, images,를 지정
	 * .formLogin를 통해서 인증이 필요한 페이지 접근 시 로그인 페이지로 유도
	 */
	@Bean
 	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
 		http
 			.csrf(csrf->csrf.disable()) //csrf 비활성화
 			.authorizeHttpRequests(authorize->authorize
 				.antMatchers("/css/**","/images/**","/js/**","/slide/**","/summernote/**","/"
 						,"/join"
 						,"/header"

 						,"/goods/**"
 						,"/footer").permitAll()

 				//.antMatchers("https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css").permitAll()
 				//.antMatchers("https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js").permitAll()
 				.antMatchers("/myPage/**").hasRole("USER")
 				.antMatchers("/admin/**").hasRole("ADMIN")
 				.anyRequest().authenticated())//나머지는 인증(로그인)해야해요0
 			.formLogin(formLogin -> formLogin
					.loginPage("/login")
					.loginProcessingUrl("/login")
					.usernameParameter("email") //default=username--form
					.passwordParameter("password") //default=password--form
					.permitAll()
					)
 			.oauth2Login(oauth2->oauth2
 					.loginPage("/login")
 					.userInfoEndpoint(userInfo->userInfo
 							.userService(myOauth2UserService())));
 		
 		
 		return http.build();
 	
 	}

	@Bean
	OAuth2UserService<OAuth2UserRequest, OAuth2User> myOauth2UserService() {
		return new MyOauth2UserService();
	}

}
