package com.bookmanger.common.service;

import java.io.Serializable;
import java.util.List;

import com.bookmanger.common.dao.BaseDao;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;



public interface BaseDaoService<T> {
	public T get(Serializable id);
	
	public BaseDao getDao();
		

	public Serializable save(T entity);
	
	public void update(T entity) ;
	
	public void delete(T entity);
	public PaginationResponse<T> getByPage(final int pageNumber, final int pageSize,
			List<QueryCondition> cons);
}
