package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BoardBean;

@Repository
public class BoardDAOImpl {

	@Autowired
	private SqlSession session;
	
	// 게시판 저장 
	public void insertBoard(BoardBean board) throws Exception {
		session.insert("boardns.board_insert", board);
	}
	
	// 데이터 갯수	 
	public int getListCount() throws Exception {
		return session.selectOne("boardns.board_count");
	}
		
	// 게시판 목록  
	public List<BoardBean> getBoardList(int page) throws Exception {
		List<BoardBean> list = session.selectList("boardns.board_list", page);
		return list;
	}
	
	// 상세 페이지 
	public BoardBean getBoardCont(int board_num) throws Exception {
		return session.selectOne("boardns.board_cont",board_num);
	}
	
	// 조회수 증가  
	public void boardHit(int board_num) throws Exception {
		session.update("boardns.board_hit", board_num);		
	}

	// 게시판 수정 
	public void boardEdit(BoardBean board) throws Exception {
		session.update("boardns.board_edit", board);		
	}
	
	// 게시판 삭제 
	public void boardDelete(int board_num) throws Exception {
		session.delete("boardns.board_del", board_num);				
	}
	
	// 답변글 레벨 증가 
	public void refEdit(BoardBean board) throws Exception {
		session.update("boardns.board_Level", board);		
	}
	
	// 답변글 저장 
	public void boardReplyOk(BoardBean board) throws Exception {
		session.insert("boardns.board_reply", board);		
	}

}
