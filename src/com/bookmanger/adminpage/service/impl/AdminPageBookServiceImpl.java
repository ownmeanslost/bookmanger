package com.bookmanger.adminpage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmanger.adminpage.dao.AdminPageBookDao;
import com.bookmanger.adminpage.service.AdminPageBookService;
import com.bookmanger.adminpage.vo.HaveBorrowVO;
import com.bookmanger.common.dao.BaseDao;
import com.bookmanger.common.model.Book;
import com.bookmanger.common.service.impl.BaseDaoServiceImpl;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;


public class AdminPageBookServiceImpl extends BaseDaoServiceImpl<Book> implements AdminPageBookService{

	@Autowired
	AdminPageBookDao adminPageBookDao;
	@Override
	public BaseDao getDao() {
	
		return adminPageBookDao;
	}
	@Override
	public PaginationResponse<HaveBorrowVO> getHaveBorrow(
			List<QueryCondition> cons) {
		
		return adminPageBookDao.getHaveBorrow(cons);
	}
	@Override
	public PaginationResponse<HaveBorrowVO> getHaveExpire(
			List<QueryCondition> cons) {
		PaginationResponse<HaveBorrowVO> pa = adminPageBookDao
				.getHaveBorrow(cons);
		// 删除借阅天数大于等于0的
		for (int i = 0; i < pa.getRows().size(); i++) {
			if (Integer.parseInt((pa.getRows().get(i).getRemainingTime())) >= 0) {
				pa.getRows().remove(i);
				i = i - 1;
				pa.setTotal(pa.getTotal() - 1);
			}

		}
		return pa;
	}
}
