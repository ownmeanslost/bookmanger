package com.bookmanger.userpage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmanger.common.model.User;
import com.bookmanger.userpage.dao.UserDao;
import com.bookmanger.userpage.service.UserService;


public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao1;

	@Override
	public User get(String user_id) {
		
		return userDao1.get(user_id);
	}

	@Override
	public boolean updateUserInfo(User user) {
		try {
			userDao1.update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
