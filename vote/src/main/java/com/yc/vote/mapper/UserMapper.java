package com.yc.vote.mapper;

import com.yc.vote.entity.User;


public interface UserMapper {
   User login(User user);
   int register(User user);
}