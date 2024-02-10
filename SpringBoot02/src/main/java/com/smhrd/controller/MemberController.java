package com.smhrd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smhrd.entity.Role;
import com.smhrd.entity.Tbl_Member;
import com.smhrd.repository.MemberRepository;

@Controller
@RequestMapping("/guest")
public class MemberController {

	// Repository 주입
	// Interface > 추상 메소드 밖에 없음 > 객체 생성 불가
	@Autowired // Spring 메모리(Spring container) 내에서 넣어줄 수 있는 객체를 알아서 찾아서 주입
	private MemberRepository repo;
	
	// 비밀번호 인코딩해주는 PasswordEncoder 가져오기
	@Autowired
	private PasswordEncoder encoder;

	// http://localhost:8088/{ContextPath}/{mapping}/{URLMapping}
	// http://localhost:8088/boot/main

	@RequestMapping("/main")
	public String goMain() {

		return "guest/main";
	}// /main

	@RequestMapping("/join")
	public String join(Tbl_Member member) {
		// 1. 데이터 수집
		
		//권한 부여
		member.setRole(Role.MEMBER);
		
		//입력받은 비밀번호를 인코딩해서 다시 set해줘야 함
		member.setPw(encoder.encode(member.getPw()));
		
		// 2. 로직 실행 - 수집한 데이터를 DB에 저장하는 코드
		// Jpa 의 save
		// 1. ID를 기준으로 select
		// 2. 있으면 >>> update
		// 없으면 >>> insert
		repo.save(member);

		// 3. view 선택 / 데이터 응답
		return "guest/join_success";
	}// join

//	@RequestMapping("/Login")
//	public String login(Tbl_Member member, HttpSession session) {
//		// 1. 데이터 수집
//		// 2. 로직 실행
//		Tbl_Member result = repo.findByEmailAndPw(member.getEmail(), member.getPw());
//		if (result != null) {
//			session.setAttribute("user", result);
//		} else {
//			System.out.println("회원 정보가 없습니다.");
//		}
//		// 3. view 선택 / 데이터 응답
//
//		return "redirect:/guest/main";
//	}//login

}// class
