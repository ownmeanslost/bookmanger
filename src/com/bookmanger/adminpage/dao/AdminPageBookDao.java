package com.bookmanger.adminpage.dao;

import java.util.List;

import com.bookmanger.adminpage.vo.HaveBorrowVO;
import com.bookmanger.common.dao.BaseDao;
import com.bookmanger.common.model.Book;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;


public interface AdminPageBookDao extends BaseDao<Book>{
	public PaginationResponse<HaveBorrowVO> getHaveBorrow(List<QueryCondition> cons);
}
