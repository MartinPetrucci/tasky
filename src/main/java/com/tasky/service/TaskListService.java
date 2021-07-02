package com.tasky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasky.model.Board;
import com.tasky.model.TaskList;
import com.tasky.repository.TaskListRepository;
import com.tasky.utils.TaskyUtils;

@Service
public class TaskListService {

	@Autowired
	TaskListRepository taskListRepository;
	
	@Autowired
	BoardService boardService;
	
	TaskyUtils<TaskList> utils = new TaskyUtils<TaskList>();
	
	public TaskList createTaskList(TaskList taskList, int boardId) {
		Board board = boardService.getBoard(boardId);
		taskList.setBoard(board);
		List<TaskList> taskLists = board.getTaskLists();
		taskLists.add(taskList);
		board.setTaskLists(taskLists);
		boardService.updateBoard(board);
		return utils.getLast(taskLists);
	}
	
	public TaskList updateTaskList(TaskList taskList) {
		return taskListRepository.save(taskList);
	}
	
	public TaskList getTaskList(int id) {
		return taskListRepository.findById(id).get();
	}
	
	
}
