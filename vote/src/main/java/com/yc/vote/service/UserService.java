package com.yc.vote.service;

import com.yc.vote.entity.User;

public interface UserService {
	User login(User user);
	int register(User user);
}
