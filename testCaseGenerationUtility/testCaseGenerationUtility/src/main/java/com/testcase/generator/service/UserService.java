package com.testcase.generator.service;

import com.testcase.generator.model.User;

public interface UserService {

	public User findUserByName(String name);
	public void saveUser(User user);
}
