package com.smhrd.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Tbl_Board {
	//글번호
	//JPA를 쓸 때, 참조 자료형으로 선언하는 것이 좋다
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private Long idx;
	//제목
	@Column(length = 100, nullable = false)
	private String title;
	//작성자(FK)
	//실제 컬럼 이름은 "컬럼명_참조받은컬럼명"
	@ManyToOne
	@JoinColumn(referencedColumnName = "email")
	private Tbl_Member writer;
	//내용
	@Column(length = 1000, nullable = false)
	private String content;
	//이미지
	private String img;
	//작성일
	// default 지정
	@Column(columnDefinition = "datetime default now()", insertable = false, updatable = false)
	private Date indate;
	//조회수
	@Column(columnDefinition = "int default 0",insertable = false, updatable = false)
	private Long count;
	
	//FK를 사용하는 경우 toString 메소드를 직접 Override 할 것
	@Override
	public String toString() {
		return "Tbl_Board";
	}

}
