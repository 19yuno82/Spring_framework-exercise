package com.smhrd.frontController;

import java.util.HashMap;

import com.smhrd.controller.BoardDetailPage;
import com.smhrd.controller.BoardMainPageService;
import com.smhrd.controller.BoardWritePageService;
import com.smhrd.controller.BoardWriteService;

public class handlermapping {

	//handlermapping : FrontController에게 어떤 POJO를 호출해야 하는지 알려주는 역할
	
	//boardList.do -> BoardListController
	//boardInsert.do -> BoardInsertController
	
	//검색이 빠른 HashMap 자료구조 사용
	//key : 요청이 들어온 주소(String)
	//value : 호출할 POJO(POJO의 상위클래스인 command)
	private HashMap<String, command> mappings;
	
	//생성자 만들기 -> 객체가 생성이 될 때 key,value를 등록하는 역할
	public handlermapping() {
		mappings = new HashMap<String, command>();
		
		//장부에 추가 -> put메소드 사용
		mappings.put("BoardWriteService.do", new BoardWriteService() );
		mappings.put("BoardWritePageService.do", new BoardWritePageService() );
		mappings.put("BoardMainPageService.do", new BoardMainPageService() );
		mappings.put("BoardDetailPage.do", new BoardDetailPage() );
	}
	
	//POJO 를 frontcontroller에게 return 해주는 메소드
	public command getPOJO(String result) {
		//Hashmap의 get(key) : 해당 key 의 value를 호출하는 메소드
		return mappings.get(result);
	}
	
}
