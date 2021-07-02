package com.tasky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasky.model.User;
import com.tasky.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User registerUser(User user) {
		return userRepository.save(user);
	}
	
}
