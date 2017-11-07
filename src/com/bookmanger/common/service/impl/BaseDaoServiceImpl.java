package com.bookmanger.common.service.impl;

import java.io.Serializable;
import java.util.List;

import com.bookmanger.common.service.BaseDaoService;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;



public abstract class BaseDaoServiceImpl<T> implements BaseDaoService<T> {
	
	
	@Override
	public T get(Serializable id) {
		if(id==null)
		return null;
		return (T) getDao().get(id);
	}

	@Override
	public Serializable save(T entity){
		return  (Serializable)getDao().save(entity);
	};
	@Override
	public void update(T entity){
		getDao().update(entity);
	};
	
	@Override
	public void delete(T entity) {
		getDao().delete(entity);
	}
	@Override
	public PaginationResponse<T> getByPage(int pageNumber, int pageSize,
			List<QueryCondition> cons) {
		return  getDao().getByPage(pageNumber, pageSize, cons);
		
	}
}
