package com.bookmanger.adminpage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmanger.adminpage.dao.AdminPageAdminDao;
import com.bookmanger.adminpage.service.AdminPageAdminService;
import com.bookmanger.common.dao.impl.BaseDaoImpl;
import com.bookmanger.common.model.Administer;

public class AdminPageAdminServiceImpl implements AdminPageAdminService {

	@Autowired
	AdminPageAdminDao adminPageAdminDao;

	@Override
	public Administer get(String user_id) {

		return adminPageAdminDao.get(user_id);
	}

	@Override
	public boolean updateAdministerInfo(Administer administer) {
		try {
			adminPageAdminDao.update(administer);
			return true;
		} catch (Exception e) {
			return false;
		}
	}



}
