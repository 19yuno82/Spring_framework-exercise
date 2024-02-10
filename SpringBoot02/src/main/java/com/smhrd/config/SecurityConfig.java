package com.smhrd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //spring Security를 적용 시킬 것이다
public class SecurityConfig {
	
	// 로그인 인증을 진행할 Service 객체를 생성
	@Autowired
	private UserDetailService userDetailService;
	
	// 비밀번호를 인코딩해주는 객체를 Bean으로 등록시키기
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	// SpringSecurity의 Filter를 Bean으로 등록시키기
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)  throws Exception {
		
		// 1. CSRF 사용 끄기
		http.csrf().disable();
		
		// 2. http 요청을 권한을 이용해서 제어
		http.authorizeHttpRequests()
		.antMatchers("/","/assets/**","/images/**","/save/**") //antMatchers(URL 패턴 정의), 어떤 URL에 권한을 설정할지
		.permitAll() //모든 사람들이 접근할 수 있게 하겠다.
		.antMatchers("/guest/**")
		.permitAll()
		.antMatchers("/member/**")
		.hasRole("MEMBER") // 특정 역할을 가진 사용자만 허락하겠다
		.and()
		.formLogin() // 로그인 form을 사용하겠다
		.loginPage("/guest/main") //로그인 페이지로 가기 위한 URL을 지정 
		                          //만약 POST 방식으로 요청하면 >> 로그인 로직 실행
		                          //파라미터의 이름의 기본값이 username과 password로 지정되어 있음
		.usernameParameter("email")
		.passwordParameter("pw")
		.defaultSuccessUrl("/guest/main") //만약 로그인이 성공하면 어디로 요청할지
		.and()
		.logout() //로그아웃 기능을 활성화하겠다
		.logoutUrl("/member/logout") //어떤 요청을 보냈을 때, 로그아웃을 실행할건지
		.logoutSuccessUrl("/guest/main") //로그아웃 성공시 어디로 갈건지
		;
		
		// 3. login에 사용할 Service를 연결
		http.userDetailsService(userDetailService);
		
		// 4. http 객체를 빌드해서 filterCahin를 만들어 리턴
		return http.build();
		
	}
	

}
