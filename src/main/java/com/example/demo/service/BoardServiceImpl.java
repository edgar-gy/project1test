package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDAOImpl;
import com.example.demo.model.BoardBean;

@Service
public class BoardServiceImpl {

	@Autowired
	private BoardDAOImpl boardDao;

	// 게시판 저장
	public void insert(BoardBean b) throws Exception {
		boardDao.insertBoard(b);
	}

	// 데이터 갯수
	public int getListCount() throws Exception {
		return boardDao.getListCount();
	}

	// 게시판 목록
	public List getBoardList(int page) throws Exception {
		return boardDao.getBoardList(page);
	}

	// 조회수 증가
	public void hit(int board_num) throws Exception {
		boardDao.boardHit(board_num);
	}

	// 상세정보
	public BoardBean board_cont(int board_num) throws Exception {
		BoardBean board = boardDao.getBoardCont(board_num);
		return board;
	}

	// 게시판 수정
	public void edit(BoardBean b) throws Exception {
		boardDao.boardEdit(b);
	}

	// 게시판 삭제
	public void del_ok(int board_num) throws Exception {
		boardDao.boardDelete(board_num);
	}

	// 게시판 댓글 달기
	public void reply_ok(BoardBean board) throws Exception {
		boardDao.refEdit(board); // 기존 댓글 board_re_seq값 1증가

		board.setBoard_re_lev(board.getBoard_re_lev() + 1); // 부모보다 1증가된 값을 저장함
		board.setBoard_re_seq(board.getBoard_re_seq() + 1);

		boardDao.boardReplyOk(board);
	}

}
