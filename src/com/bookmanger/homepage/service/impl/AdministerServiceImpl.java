package com.bookmanger.homepage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmanger.common.model.Administer;
import com.bookmanger.homepage.dao.AdminiserDao;
import com.bookmanger.homepage.service.AdministerService;

public class AdministerServiceImpl implements AdministerService{

	@Autowired
	AdminiserDao adminiserDao;
	@Override
	public boolean checkUser_id( String user_id, String password) {
		Administer administer=adminiserDao.get(user_id);
		if(administer!=null&&administer.getPassword().equals(password)){
			return true;
		}
		return false;
	}

}
