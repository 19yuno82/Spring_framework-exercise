package com.smhrd.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Getter/Setter
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 전체 필드를 초기화하는 생성자
public class Tbl_Member {

	// DTO : Data Transfer Object
	// DB 의 Table에서 꺼낸 데이터를 담을 수 있도록 설계
	// Table에 있는 컬럼이 DTO의 필드로 존재해야 함(이름도 같아야 함)
	// 반드시 필드들에 대한 getter/Setter 있어야 함
	// 기본생성자가 있어야 함

	// ORM
	// Java 객체와 DB의 Table 연결
	// Java DTO를 설계만 해도 DB 에 테이블이 자동으로 생성

	// email
	// @Column 매개변수를 이용해서 컬럼의 상세한 내용 설정 가능
	// insertable
	// updatable >> insert문 또는 update문이 자동완성될 때, 포함될 건지

	@Id
	@Column(length = 50, updatable = false)
	private String email;
	// pw
	@Column(nullable = false)
	private String pw;
	// tel
	@Column(length = 50)
	private String tel;
	// address
	private String address;
	
	//사용자의 권한을 가지고 있을 컬럼
	private Role role;
	
	//FK에 대한 필드 설정
	@OneToMany(mappedBy = "writer")
	private  List<Tbl_Board> board;
	
	@Override
	public String toString() {
		return "Tbl_Member";
	}

}
