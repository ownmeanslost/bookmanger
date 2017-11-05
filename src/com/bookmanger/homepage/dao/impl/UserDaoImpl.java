package com.bookmanger.homepage.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bookmanger.common.dao.impl.BaseDaoImpl;
import com.bookmanger.common.model.User;
import com.bookmanger.homepage.dao.UserDao;
import com.bookmanger.homepage.vo.UserVO;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public void addUser(UserVO user) {
		String sql="insert into user values "
				+ " ('"+user.getUser_id()+"','"+user.getName()+"','"+user.getPassword()+"','"
				+user.getSex()+"','"+user.getId_num()+"')";
		try{
			jdbcTemplate.execute(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Map<String, Object>> checkExist(String user_id) {
		String sql="select * from user where user_id= '"+user_id+"'";
		List<Map<String, Object>> list=null;
		try{
		 list=jdbcTemplate.queryForList(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
