package com.aviskar.example.service;

import com.aviskar.example.model.User;

public interface UserService {

	User findOneByEmail(String email);

	void saveOrUpdate(User user);
}
