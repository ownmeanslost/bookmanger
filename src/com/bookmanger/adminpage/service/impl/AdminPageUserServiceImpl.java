package com.bookmanger.adminpage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmanger.adminpage.dao.AdminPageUserDao;
import com.bookmanger.adminpage.service.AdminPageUserService;
import com.bookmanger.common.dao.BaseDao;
import com.bookmanger.common.model.User;
import com.bookmanger.common.service.impl.BaseDaoServiceImpl;

public class AdminPageUserServiceImpl extends BaseDaoServiceImpl<User> implements AdminPageUserService{

	@Autowired
	AdminPageUserDao adminPageUserDao;
	
	@Override
	public BaseDao getDao() {
		
		return adminPageUserDao;
	}

}
