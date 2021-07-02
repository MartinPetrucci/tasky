package com.tasky.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tasky.core.TaskyResponse;
import com.tasky.model.Board;
import com.tasky.model.TaskList;
import com.tasky.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {

	private static Logger logger = LogManager.getLogger(UserController.class);
	
	private static final String logHeader = "[BOARD CONTROLLER]-> ";
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/create")
	public TaskyResponse<Board> createBoard(@RequestBody Board board) {
		TaskyResponse<Board> response = new TaskyResponse<Board>();
		
		try {
			boardService.createBoard(board);
			response.setHttpCode(HttpStatus.CREATED);
			response.setEntity(board);
			logger.info(logHeader + "Board created: " + board.toString());
		} catch(Exception e) {
			response.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setError(e.getMessage());
			logger.error(logHeader + e.getMessage());
		}
		
		return response;
	}
	
	@GetMapping("/getTaskLists/{id}")
	@ResponseBody
	public TaskyResponse<List<TaskList>> getTaskLists(@PathVariable("id") int id) {
		TaskyResponse<List<TaskList>> response = new TaskyResponse<List<TaskList>>();
		try {
			Board board = boardService.getBoard(id);
			response.setEntity(board.getTaskLists());
			response.setHttpCode(HttpStatus.OK);
		} catch(Exception e) {
			response.setHttpCode(HttpStatus.NOT_FOUND);
			response.setError(e.getMessage());
			logger.error(logHeader + e.getMessage());
		}
		return response;
		
	}
	
	
}
