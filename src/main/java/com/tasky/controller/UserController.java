package com.tasky.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasky.core.TaskyResponse;
import com.tasky.model.User;
import com.tasky.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static Logger logger = LogManager.getLogger(UserController.class);
	
	private static final String logHeader = "[USER CONTROLLER]-> ";
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public TaskyResponse<User> saveUser(@RequestBody User user) {
		TaskyResponse<User> response = new TaskyResponse<User>();
		
		try {
			userService.registerUser(user);
			response.setHttpCode(HttpStatus.CREATED);
			response.setEntity(user);
			logger.info(logHeader + "User registered: " + user.toString());
		} catch(Exception e) {
			response.setHttpCode(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setError(e.getMessage());
			logger.error(logHeader + e.getMessage());
		}
		
		return response;
	}
	
}
