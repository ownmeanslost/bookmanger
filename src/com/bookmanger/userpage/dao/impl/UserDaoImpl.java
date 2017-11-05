package com.bookmanger.userpage.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bookmanger.common.dao.impl.BaseDaoImpl;
import com.bookmanger.common.model.User;
import com.bookmanger.userpage.dao.UserDao;


public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
}
