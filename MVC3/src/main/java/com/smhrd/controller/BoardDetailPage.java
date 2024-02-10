package com.smhrd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.frontController.command;
import com.smhrd.model.Board;
import com.smhrd.model.bDAO;

public class BoardDetailPage implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		Board board = new bDAO().board(num);
		
		request.setAttribute("board", board);
		
		// TODO Auto-generated method stub
		return "BoardDetail";
	}

}
