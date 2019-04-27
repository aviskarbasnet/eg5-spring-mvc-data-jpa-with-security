package com.aviskar.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aviskar.example.model.User;
import com.aviskar.example.repository.UserRepository;
import com.aviskar.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findOneByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}

	@Override
	public void saveOrUpdate(User user) {
		userRepository.save(user);
	}
}
