package com.bookmanger.homepage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmanger.common.dao.BaseDao;
import com.bookmanger.common.model.UserList;
import com.bookmanger.common.service.impl.BaseDaoServiceImpl;
import com.bookmanger.homepage.dao.HomePageUserListDao;
import com.bookmanger.homepage.service.HomePageUserListService;

public class HomePageUserListServiceImpl extends BaseDaoServiceImpl<UserList> implements HomePageUserListService{

	@Autowired
	HomePageUserListDao homePageUserListDao;
	@Override
	public BaseDao getDao() {
		return homePageUserListDao;
	}

}
