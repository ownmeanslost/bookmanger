package com.bookmanger.homepage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmanger.common.model.Bulletin;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;
import com.bookmanger.homepage.dao.BulletinDao;
import com.bookmanger.homepage.service.BulletinService;

public class BulletinServiceImpl implements BulletinService{

	@Autowired
	BulletinDao bulletinDao;
	@Override
	public PaginationResponse<Bulletin> getOtherList(String pageNumber,
			String pageSize, List<QueryCondition> cons) {
		PaginationResponse<Bulletin> re=bulletinDao.getByPage(Integer.parseInt(pageNumber),Integer.parseInt( pageSize), cons);
		re.setTotal(re.getTotal()-1);
		return re;
		
	}
	@Override
	public Bulletin getReaderKnow() {
		
		return bulletinDao.get("123");
	}

}
