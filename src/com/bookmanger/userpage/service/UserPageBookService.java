package com.bookmanger.userpage.service;

import java.util.List;

import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;
import com.bookmanger.userpage.vo.BorrowInfoVO;
import com.bookmanger.userpage.vo.HaveBorrowVO;

public interface UserPageBookService {
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
	/**
	 * 读者借书
	 * @param ISDN
	 * @return
	 */
	public BorrowInfoVO userBorrow(String ISDN,List<QueryCondition> cons,String user_id);
}
