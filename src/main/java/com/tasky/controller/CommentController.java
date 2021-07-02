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
import com.tasky.model.Comment;
import com.tasky.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

private static Logger logger = LogManager.getLogger(CommentController.class);
	
	private static final String logHeader = "[COMMENT CONTROLLER]-> ";
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/create")
	public TaskyResponse<Comment> createComment(@RequestBody Comment comment, @RequestParam(name="taskId") int taskId) {
		TaskyResponse<Comment> response = new TaskyResponse<Comment>();
		try {
			Comment commentCreated = commentService.createComment(comment, taskId);
			response.setHttpCode(HttpStatus.CREATED);
			response.setEntity(commentCreated);
			logger.info(logHeader + "Comment created: " + commentCreated.toString());
		} catch(Exception e) {
			response.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setError(e.getMessage());
			logger.error(logHeader + e.getMessage());
		}
		
		return response;
	}
	
}
