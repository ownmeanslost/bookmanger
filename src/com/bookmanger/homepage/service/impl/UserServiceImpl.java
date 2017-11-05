package com.bookmanger.homepage.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmanger.common.model.User;
import com.bookmanger.homepage.dao.UserDao;
import com.bookmanger.homepage.service.UserService;
import com.bookmanger.homepage.vo.UserVO;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public void addUser(UserVO user) {
		userDao.addUser(user);
	}

	@Override
	public UserVO checkExist(String user_id) {

		List<Map<String, Object>> list = userDao.checkExist(user_id);
		UserVO user = new UserVO();
		if (list != null) {
			user.setUser_id(list.get(0).get("user_id").toString());
			user.setId_num(list.get(0).get("id_num").toString());
			user.setName(list.get(0).get("name").toString());
			user.setPassword(list.get(0).get("password").toString());
			user.setSex(list.get(0).get("sex").toString());
		}
		return user;
	}

	/**
	 * 验证找回密码
	 * 
	 * 输入的用户名和身份证是否匹配
	 */
	@Override
	public String checkFindPassword(UserVO vo) {

		User us = userDao.get(vo.getUser_id());
		if (us!=null&&us.getId_num().equals(vo.getId_num())) {
			us.setPassword(vo.getPassword());
			userDao.update(us);
			return "1";
		} else {
			return "2";
		}
	}

	@Override
	public boolean checkUser_id(String user_id, String password) {
		User user= userDao.get(user_id);
		if(user!=null&&user.getPassword().equals(password)){
			return true;
		}
		return false;
	}

}
