package com.bookmanger.homepage.dao;

import java.util.List;
import java.util.Map;

import com.bookmanger.common.dao.BaseDao;
import com.bookmanger.common.model.Book;

public interface BookDao extends BaseDao<Book>{
	public List<Map<String,Object>> findBook(String ISDN);
	
}
