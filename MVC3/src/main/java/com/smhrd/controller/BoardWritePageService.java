package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.frontController.command;

public class BoardWritePageService implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//BoardWrite.jsp로 이동시켜주는 역할
		//페이지를 요청하는 controller이기 때문에 내부에 코드작성X
		return "BoardWrite";
	}

}
