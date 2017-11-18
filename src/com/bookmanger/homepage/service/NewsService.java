package com.bookmanger.homepage.service;

import java.util.List;

import com.bookmanger.common.model.News;
import com.bookmanger.common.service.BaseDaoService;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;

public interface NewsService extends BaseDaoService<News>{
	/**
	 * 分页
	 * @param pageNumber
	 * @param pageSize
	 * @param cons
	 * @return
	 */
	public PaginationResponse<News> getOtherList(String pageNumber,
			String pageSize, List<QueryCondition> cons);
}
