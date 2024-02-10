package com.smhrd.frontController;

public class ViewResolver {

	//ViewResolver : POJO가 반납한 viewname을 풀네임으로 만들어주는 역할
	//viewname -> 풀네임
	//BoardMain -> MVC/WEB_INF/views/BoardMain.jsp
	public String  makeViewName(String viewname) {
		return "WEB-INF/views/"+viewname+".jsp";
	}
}
