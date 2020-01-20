package com.korea.k88.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.korea.k88.board.domain.Board900;
import com.korea.k88.board.persistance.BoardRepository;

public class BoardService implements BoardServiceI {
	@Autowired
	private BoardRepository boardRepo;
	
	@Override
	public void insertBoard(Board900 board) {
		boardRepo.save(board);
	}

	@Override
	public void updateBoard(Board900 board) {
		Board900 findBoard = boardRepo.findById(board.getSeq()).get();
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(findBoard);
	}

	@Override
	public void deleteBoard(Board900 board) {
		boardRepo.deleteById(board.getSeq());
	}

	@Override
	public Board900 getBoard(Board900 board) {
		return boardRepo.findById(board.getSeq()).get();
	}

	@Override
	public Page<Board900> getBoardList(Board900 board) {
		return (Page<Board900>)boardRepo.findAll();
	}

}
