package com.smhrd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.frontController.command;
import com.smhrd.model.bDAO;
import com.smhrd.model.Board;

public class BoardMainPageService implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		//1.db에서 게시글 데이터 가져오기
		List<Board> bList = new bDAO().b_list();
		//2.view에서 해당 게시글 데이터를 불러오기 위해 request객체에 객체 바인딩
		request.setAttribute("bList", bList);
		// TODO Auto-generated method stub
		return "BoardMain";
	}

}
