package com.A31.shop.security;


import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.A31.shop.domain.entity.MemberEntity;
import com.A31.shop.domain.entity.MemberEntityRepository;


public class MyUserDetailsService implements UserDetailsService {
	
	
	/*
	 * DB값의 있는 username(email)을 찾아야 되므로 Bean에 등록되어 있는 UserRepositoty을 가져온다. 
	 */
	@Autowired
	private MemberEntityRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		/*
		 * 반환 타입이 Optional 일시 변경 해주어야 함.
		 * Optional 경우 NULL값의 예외처리를 좀 더 효과적으로 할 수 있음.
		 * Optional 일시 아래코드 참조
		 * repository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("존재하지 않는 유저"));
		 * NULL의 경우에서의 예외처리를 해주어야 함.
		 */
		MemberEntity user = repository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("존재하지 않는 유저"));
		/*
		 * if(user==null) { System.out.println("존재하지 않는 회원입니다."); }else {
		 * System.out.println("존재하는 회원입니다."); }
		 */
		
		
		/*
		 * DB에 해당하는 사용자가 있으면 사용자의 ROLE(권한)을 객체에 넣어 반환.
		 * Spring.io Security 를 참고하여 ROLE을 반환타입에 맞게 변환해준다.
		 */
		Set<SimpleGrantedAuthority> grnatedAuthority = user.getUserRoles().stream()
				.map((myRole) -> new SimpleGrantedAuthority("ROLE_"+myRole.name()))
				.collect(Collectors.toSet());
		
		
		return new User(email, user.getPassword(), grnatedAuthority);
	}

}
