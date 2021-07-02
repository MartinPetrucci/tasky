package com.tasky.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasky.core.TaskyResponse;
import com.tasky.model.Task;
import com.tasky.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	TaskService taskService;
	
	private static Logger logger = LogManager.getLogger(TaskController.class);
	
	private static final String logHeader = "[TASK CONTROLLER]-> ";
	
	@PostMapping("/create")
	public TaskyResponse<Task> createTask(@RequestBody Task task, @RequestParam(name="taskListId", required=true) int taskListId) {
		TaskyResponse<Task> response = new TaskyResponse<Task>();
		try {
			Task taskCreated = taskService.createTask(task, taskListId);
			response.setHttpCode(HttpStatus.CREATED);
			response.setEntity(taskCreated);
			logger.info(logHeader + "Task created: " + taskCreated.toString());
		} catch(Exception e) {
			response.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setError(e.getMessage());
			logger.error(logHeader + e.getMessage());
		}
		return response;
	}
	
	@GetMapping("/get/{id}")
	public TaskyResponse<Task> getTask(@PathVariable("id") int id) {
		TaskyResponse<Task> response = new TaskyResponse<Task>();
		try {
			Task task = taskService.getTask(id);
			response.setEntity(task);
			response.setHttpCode(HttpStatus.OK);
		} catch(Exception e) {
			response.setHttpCode(HttpStatus.NOT_FOUND);
			response.setError(e.getMessage());
			logger.error(logHeader + e.getMessage());
		}
		return response;
	}
	
}
