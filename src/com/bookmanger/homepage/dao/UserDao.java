package com.bookmanger.homepage.dao;

import java.util.List;
import java.util.Map;

import com.bookmanger.common.dao.BaseDao;
import com.bookmanger.common.model.User;
import com.bookmanger.homepage.vo.UserVO;

public interface UserDao extends BaseDao<User>{
	public void addUser(UserVO user);
	
	public List<Map<String,Object>> checkExist(String user_id);
}
