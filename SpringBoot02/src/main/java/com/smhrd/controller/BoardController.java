package com.smhrd.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.entity.Tbl_Board;
import com.smhrd.repository.BoardRepository;

@Controller
@RequestMapping("/member")
public class BoardController {
	
	@Autowired
	private BoardRepository repo;
	
	@Value("${save.path}") //application.properties에 정의해놓은 데이터 받아오기
	private String savePath;
	
	@RequestMapping("/List")
	public String list(Model model) {
		//1.데이터 수집
		//2. 로직 실행
		List<Tbl_Board> list = repo.findAll();
		model.addAttribute("list",list);
		//3. view 선택
		return "member/boardMain";
	}
	@GetMapping("/write")
	public String goWrite() {
		return "member/writerBoard";	
	}
	
	@PostMapping("/write")
	public String setWrite(MultipartFile file, Tbl_Board board) {
		//1. 데이터 수집
		// 파일 저장하기
		// 랜덤한 문자열 생성해서 파일 이름 앞에 붙이기(uid)	
		String uuid=UUID.randomUUID().toString();
		String filename= uuid +"_"+ file.getOriginalFilename();
		
		//파일을 저장하기 위한 경로 객체 만들기
		Path path = Paths.get(savePath + filename);
		
		//해당경로에 파일 저장
		try {
			file.transferTo(path);
			board.setImg(filename);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//2. 로직 실행
		repo.save(board);
		//3. view 선택
		return "redirect:/member/List";
	}
	@RequestMapping("/detail")
	public String boardDetail(Long idx, Model model) {
		Tbl_Board board = repo.findById(idx).get();
		model.addAttribute("board",board);
		return "member/viewBoard";
	}
	
//	@RequestMapping("/Update")
//	public String infoUpdate(Tbl_Board board) {
//		repo.save(board);
//		return "member/update";
//	}

}//class
