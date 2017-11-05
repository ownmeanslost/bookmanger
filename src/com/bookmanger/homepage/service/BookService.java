package com.bookmanger.homepage.service;

import java.util.List;

import com.bookmanger.common.model.Book;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;
import com.bookmanger.homepage.vo.BookVO;

public interface BookService {
	public BookVO findOneBook(String ISDN);

	public PaginationResponse<Book> getBookList(String pageNumber,
			String pageSize, List<QueryCondition> cons);
}
