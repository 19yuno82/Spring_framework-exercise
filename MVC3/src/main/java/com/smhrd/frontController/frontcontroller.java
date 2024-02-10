package com.smhrd.frontController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.smhrd.controller.BoardWriteService;

import com.smhrd.model.Board;

import com.smhrd.model.bDAO;


@WebServlet("*.do")
public class frontcontroller extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("frontcontrol");
		request.setCharacterEncoding("UTF-8");
		
		//1. 요청 확인하기
		String requestURI =request.getRequestURI();
		System.out.println("요청이 들어온 주소 : "+ requestURI);
		String contextPath = request.getContextPath();
		System.out.println("contextPath :"+contextPath);
		String result = requestURI.substring(contextPath.length()+1);
		System.out.println("요청 서블릿 : "+result);
		
		//2. handlermapping에게 어떤 POJO를 호출해야하는지 물어보기
		handlermapping mapping = new handlermapping();
		command service = mapping.getPOJO(result);
		
		//3. 업무를 할 POJO 실행시키기 -> POJO는 viewname을 반환
		
		
		String viewname =  service.execute(request, response);
		if(viewname != null) { 
			System.out.println("viewname : "+viewname);
			
			//redirect방식 : 다른 controller(POJO)를 요청할때
			if(viewname.contains(":/")) {
				response.sendRedirect(viewname.split(":/")[1]);
			}
			//forward방식 : jsp를 요청할때
			else {
				String fullname = new ViewResolver().makeViewName(viewname);
				System.out.println("fullname : "+fullname);
				RequestDispatcher rd = request.getRequestDispatcher(fullname);
				rd.forward(request, response);
				
			}
								
			
		}
		
	}

}
