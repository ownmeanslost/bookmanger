package com.bookmanger.adminpage.service;

import java.util.List;

import com.bookmanger.adminpage.vo.HaveBorrowVO;
import com.bookmanger.common.model.Book;
import com.bookmanger.common.service.BaseDaoService;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;


public interface AdminPageBookService extends BaseDaoService<Book>{
	/**
	 * 借书记录
	 * @param pageNumber
	 * @param pageSize
	 * @param cons
	 * @return
	 */
	public PaginationResponse<HaveBorrowVO> getHaveBorrow(List<QueryCondition> cons);
	/**
	 * 到期书籍
	 * @param pageNumber
	 * @param pageSize
	 * @param cons
	 * @return
	 */
	public PaginationResponse<HaveBorrowVO> getHaveExpire(List<QueryCondition> cons);
}
