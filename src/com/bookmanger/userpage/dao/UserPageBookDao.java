package com.bookmanger.userpage.dao;

import java.util.List;

import com.bookmanger.common.dao.BaseDao;
import com.bookmanger.common.model.Book;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;
import com.bookmanger.userpage.vo.BorrowInfoVO;
import com.bookmanger.userpage.vo.HaveBorrowVO;

public interface UserPageBookDao extends BaseDao<Book> {
	public PaginationResponse<HaveBorrowVO> getHaveBorrow(List<QueryCondition> cons);
	
}
