package com.tasky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasky.model.Comment;
import com.tasky.model.Task;
import com.tasky.repository.CommentRepository;
import com.tasky.utils.TaskyUtils;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	TaskService taskService;
	
	TaskyUtils<Comment> utils = new TaskyUtils<Comment>();
	
	public Comment createComment(Comment comment, int taskId) {
		Task task = taskService.getTask(taskId);
		comment.setTask(task);
		List<Comment> comments = task.getComments();
		comments.add(comment);
		task.setComments(comments);
		taskService.updateTask(task);
		return utils.getLast(comments);
	}
}
