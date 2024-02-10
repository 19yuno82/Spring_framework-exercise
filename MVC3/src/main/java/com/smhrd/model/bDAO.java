package com.smhrd.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.sqlSessionManager;

public class bDAO {
	//Factory 생성
	SqlSessionFactory sqlSessionFactory = sqlSessionManager.getSqlSession();
	
	SqlSession sqlSession = sqlSessionFactory.openSession(true);
	
	public int writeBoard(Board vo) {
		int isUp = 0;
		try {
			isUp = sqlSession.insert("com.smhrd.db.BoardMapper.writeBoard", vo);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sqlSession.close();
		}
		return isUp;
	}
	
	public List<Board> b_list(){
		List<Board> bList = null;
		try {
			bList = sqlSession.selectList("com.smhrd.db.BoardMapper.bList");
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sqlSession.close();
		}
		
		return bList;
	}

	public int b_delete(Integer num) {
		int isDel = 0;
		try {
			isDel = sqlSession.delete("com.smhrd.db.BoardMapper.bDelete", num);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sqlSession.close();
		}
		
		return isDel;
	}
	
	public Board board(int num) {
		Board board = null;
		try {
			board = sqlSession.selectOne("com.smhrd.db.BoardMapper.detail", num);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sqlSession.close();
		}
		
		return board;
	}

}
