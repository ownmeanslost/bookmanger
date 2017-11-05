package com.bookmanger.common.dao;

import java.io.Serializable;
import java.util.List;

import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;

public abstract interface BaseDao<T> {
	public T get(Serializable id);
	
	/**
	 * 获取数据库的表名
	 * @return
	 */
	public String getTableName();
	
	public Serializable save(T entity);

	public void update(T entity) ;
	
	public PaginationResponse<T> getByPage(final int pageNumber, final int pageSize,
			List<QueryCondition> cons);
	
}
