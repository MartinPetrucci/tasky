package com.tasky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasky.model.Board;
import com.tasky.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	public Board createBoard(Board board) {
		return boardRepository.save(board);
	}
	
	public Board updateBoard(Board board) {
		return boardRepository.save(board);
	}
	
	public Board getBoard(int id) {
		return boardRepository.findById(id).get();
	}
	
}
