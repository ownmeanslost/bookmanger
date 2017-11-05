package com.bookmanger.userpage.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.transform.ToListResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bookmanger.common.dao.impl.BaseDaoImpl;
import com.bookmanger.common.model.Book;
import com.bookmanger.common.utils.DateTransfor;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;
import com.bookmanger.userpage.dao.UserPageBookDao;
import com.bookmanger.userpage.vo.HaveBorrowVO;

public class UserPageBookDaoImpl extends BaseDaoImpl<Book> implements
		UserPageBookDao {
	/**
	 * 获得借书列表 此处可用视图做优化
	 */
	@Autowired
	JdbcTemplate jdbcTemplate;

	public PaginationResponse<HaveBorrowVO> getHaveBorrow(
			List<QueryCondition> cons) {

		PaginationResponse<HaveBorrowVO> result = new PaginationResponse<>();
		String strSql = "SELECT s2.*,s3.book_name FROM	book s3,borrow_list s2  LEFT JOIN user_list s1 ON (	s1.user_id = s2.user_id	AND s1.Borrow_listnum1 = s2.borrow_listnum	OR s1.Borrow_listnum2 = s2.borrow_listnum	OR s1.Borrow_listnum3 = s2.borrow_listnum	OR s1.Borrow_listnum4 = s2.borrow_listnum	OR s1.Borrow_listnum5 = s2.borrow_listnum ) WHERE s3.book_id=s2.book_id";
		String countSql = "select borrow_num  from user_list s1 ";

		strSql += " and " + cons.get(0).toString();
		countSql += " where " + cons.get(0).toString();
		List<Map<String, Object>> list = jdbcTemplate.queryForList(strSql);
		int total = jdbcTemplate.queryForInt(countSql);
		result.setTotal(total);
		List<HaveBorrowVO> listh = new ArrayList<>();
		HaveBorrowVO ha = null;
		String str = DateTransfor.getNowDate();
		for (Map<String, Object> map : list) {
			ha = new HaveBorrowVO();
			ha.setIsdn((String) map.get("book_id"));
			ha.setBookName((String) map.get("book_name"));
			ha.setReturn_time(map.get("return_time").toString());
			ha.setRemainingTime(DateTransfor.timeXiangJian(
					map.get("return_time").toString(), str));
			listh.add(ha);
		}
		result.setRows(listh);
		return result;
	}

}
