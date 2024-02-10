package com.smhrd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.entity.Tbl_Board;

@Repository
public interface BoardRepository extends JpaRepository<Tbl_Board, Long> {
	
	// 작성자를 기준으로 select
	// select * from tbl_board where writer = ?
	public List<Tbl_Board> findByWriter_Email(String writer);
	
}
