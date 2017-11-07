package com.bookmanger.adminpage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmanger.adminpage.dao.AdminPageBorrow_labDao;
import com.bookmanger.adminpage.service.AdminPageBorrow_labService;
import com.bookmanger.common.dao.BaseDao;
import com.bookmanger.common.model.Borrow_lab;
import com.bookmanger.common.service.impl.BaseDaoServiceImpl;

public class AdminPageBorrow_labServiceImpl extends BaseDaoServiceImpl<Borrow_lab> implements AdminPageBorrow_labService{

	@Autowired
	AdminPageBorrow_labDao adminPageBorrow_labDao;
	@Override
	public BaseDao getDao() {
		
		return adminPageBorrow_labDao;
	}

}
