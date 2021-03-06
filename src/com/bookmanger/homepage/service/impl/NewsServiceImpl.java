package com.bookmanger.homepage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmanger.common.dao.BaseDao;
import com.bookmanger.common.model.News;
import com.bookmanger.common.service.impl.BaseDaoServiceImpl;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;
import com.bookmanger.homepage.dao.NewsDao;
import com.bookmanger.homepage.service.NewsService;

public class NewsServiceImpl extends BaseDaoServiceImpl<News> implements NewsService{

	@Autowired
	NewsDao newsDao;
	@Override
	public PaginationResponse<News> getOtherList(String pageNumber,
			String pageSize, List<QueryCondition> cons) {
		return newsDao.getByPage(Integer.parseInt(pageNumber),Integer.parseInt(pageSize), cons);
	}
	@Override
	public BaseDao getDao() {
		// TODO Auto-generated method stub
		return newsDao;
	}

}
