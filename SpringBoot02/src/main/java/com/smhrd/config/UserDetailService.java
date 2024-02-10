package com.smhrd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smhrd.entity.CustomUser;
import com.smhrd.entity.Tbl_Member;
import com.smhrd.repository.MemberRepository;

@Service
public class UserDetailService implements UserDetailsService {
	
	@Autowired
	private MemberRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Tbl_Member member = repo.findById(username).get();
		
		//사용자의 아이디를 이용해서 정보를 확인하고, 인증 객체를 만들어서 리턴하는 역할
		return new CustomUser(member);
	}
	
	
	
}
