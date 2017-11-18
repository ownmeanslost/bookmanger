package com.bookmanger.homepage.dao;

import java.util.List;
import java.util.Map;

import com.bookmanger.common.dao.BaseDao;
import com.bookmanger.common.model.Book;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;
import com.bookmanger.homepage.vo.HaveBorrowVO;

public interface BookDao extends BaseDao<Book>{
	public List<Map<String,Object>> findBook(String ISDN);
	
	public PaginationResponse<HaveBorrowVO> getHaveBorrow(List<QueryCondition> cons,int pageNumber, int pageSize);
	
}
