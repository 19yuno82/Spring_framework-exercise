package com.smhrd.entity;

import java.util.Collection;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Data;

@Data
public class CustomUser extends User {
	//Security 동작 과장에서 사용자가 인증를 받고 나서, 인증 정보 및 사용자 정보를 동시에 관리할 수 있는 객체

	private Tbl_Member member;
	
	public CustomUser(Tbl_Member member) {
		
		super(member.getEmail(), 
				member.getPw(), 
				AuthorityUtils.createAuthorityList("ROLE_"+member.getRole().toString()) );
		this.member = member;
	}
	
}
