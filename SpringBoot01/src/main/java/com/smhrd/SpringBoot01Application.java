package com.smhrd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //@AutoConfiguration + @ComponentScan
//@AutoConfiguration
//SpringBoot 프로젝트를 실행하기 위해 필요한 설정들이 클래스로 정의되어 있음
//SpringBoot 프로젝트 시작시
//준비해놨던 성정 클래스등을 전부 세팅
//application.properties 설정 >> json 파일을 보고 일치하는 클래스에 설정들을 세팅 >> 프로젝트에 반영
//라이브러리를 사용하기 위해 필요한 기본(필수) 설정들을 자동으로 진행

//@ComponentScan
//특정 패키지를 스캔해서 @Contorller, @RestContoller 등 특별한 클래스를 찾아
//Bean으로 생성하는 어노테이션
// Application.java 파일과 같은 위치에 있는 모든 패키지를 자동으로 스캔
// com.smhrd.~~ -> com/smhrd/Controller
public class SpringBoot01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot01Application.class, args);
	}

}
