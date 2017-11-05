package com.bookmanger.homepage.service;

import com.bookmanger.homepage.vo.UserVO;

public interface UserService {
	public void addUser(UserVO user);
	//验证唯一性
	public UserVO checkExist(String user_id);
	//找回密码验证
	public String checkFindPassword(UserVO vo);
	
	//登录验证
	public boolean checkUser_id(String user_id,String password);
	
}
