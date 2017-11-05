package com.bookmanger.userpage.service;

import com.bookmanger.common.model.User;


public interface UserService {
	public User get(String user_id);
	
	public boolean updateUserInfo(User user);
}
