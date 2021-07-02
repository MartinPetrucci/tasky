package com.tasky.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasky.core.TaskyResponse;
import com.tasky.model.TaskList;
import com.tasky.service.TaskListService;

@RestController
@RequestMapping("/taskList")
public class TaskListController {

	private static Logger logger = LogManager.getLogger(TaskListController.class);
	
	private static final String logHeader = "[TASK LIST CONTROLLER]-> ";
	
	@Autowired
	TaskListService taskListService;
	
	@PostMapping("/create")
	public TaskyResponse<TaskList> createTaskList(@RequestBody TaskList taskList, @RequestParam(name="boardId") int boardId) {
		TaskyResponse<TaskList> response = new TaskyResponse<TaskList>();
		
		try {
			TaskList taskListCreated = taskListService.createTaskList(taskList, boardId);
			response.setHttpCode(HttpStatus.CREATED);
			response.setEntity(taskListCreated);
			logger.info(logHeader + "Task List created: " + taskListCreated.toString());
		} catch(Exception e) {
			response.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setError(e.getMessage());
			logger.error(logHeader + e.getMessage());
		}
		
		return response;
	}
}
