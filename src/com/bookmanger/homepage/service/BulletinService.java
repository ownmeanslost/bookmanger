package com.bookmanger.homepage.service;

import java.util.List;

import com.bookmanger.common.model.Bulletin;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;

public interface BulletinService {
	/**
	 * 分页
	 * @param pageNumber
	 * @param pageSize
	 * @param cons
	 * @return
	 */
	public PaginationResponse<Bulletin> getOtherList(String pageNumber,
			String pageSize, List<QueryCondition> cons);
	/**
	 * bulletin作为读者须知第一条数据
	 * @return
	 */
	public Bulletin getReaderKnow();
}
