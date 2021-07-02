package com.tasky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasky.model.Task;
import com.tasky.model.TaskList;
import com.tasky.repository.TaskRepository;
import com.tasky.utils.TaskyUtils;

@Service
public class TaskService {

	@Autowired 
	TaskRepository taskRepository;
	
	@Autowired
	TaskListService taskListService;
	
	TaskyUtils<Task> utils = new TaskyUtils<Task>();
	
	public Task createTask(Task task, int taskListId) {
		TaskList taskList = taskListService.getTaskList(taskListId);
		task.setTaskList(taskList);
		List<Task> list = taskList.getTasks(); 
		list.add(task);
		taskList.setTasks(list);
		taskListService.updateTaskList(taskList);
		return utils.getLast(list);
	}

	public Task getTask(int id) {
		return taskRepository.findById(id).get();
	}
	
	public Task updateTask(Task task) {
		return taskRepository.save(task);
	}
	
}
