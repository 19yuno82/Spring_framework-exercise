package com.smhrd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Tbl_Member;

@Repository // 이 파일이 JPA Repository임을 명시, scan 되도록 함
public interface MemberRepository extends JpaRepository<Tbl_Member, String>{
	
	// Repository 는 반드시 JpaRepository Interface를 상속받아야 함
	// JpaRepository<T, ID>
	// T : table과 연결된 entity
	// ID : entity 내 PK(ID)의 자료형
	
	// JPA : No sql, sql문을 쓰지 말자
	// JpaRepository 안에 CRUD 메소드가 정의되어 있음
	// hibernate 구현체가 테이블과, ID에 맞게 맞춰서 자동으로 구현
	
	//특별한 조건을 가지는 메소드는 직접 구현
	//1) 메소드 이름 규칙을 이용한 구현, 카멜기법만 사용할 것
	public Tbl_Member findByEmailAndPw(String email, String pw);
	
	//2) @Query 어노테이션을 이용해서 직접 sql문을 작성하는 방법
	//복잡한 쿼리문 작성하기 힘듦(join, 서브쿼리 등)
	//JPA 단일 보다는 mybatis 를 겸용하는 경우가 많다
//	@Query("select * from tbl_member where email = :email and pw = :pw")
//	public Tbl_Member login(String email, String pw);
	
	
}//interface
