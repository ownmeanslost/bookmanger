package com.bookmanger.homepage.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bookmanger.common.dao.impl.BaseDaoImpl;
import com.bookmanger.common.model.Book;
import com.bookmanger.common.utils.DateTransfor;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;
import com.bookmanger.homepage.dao.BookDao;
import com.bookmanger.homepage.vo.HaveBorrowVO;

public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// 根据isdn查找书
	@Override
	public List<Map<String, Object>> findBook(String ISDN) {

		String sql = "select s1.*,s2.kucun from book s1,borrow_lab s2 where s1.book_id="
				+ ISDN + " and s1.book_id=s2.book_id";
		List<Map<String, Object>> list = null;
		if (ISDN.equals(""))
			return list;
		try {
			list = jdbcTemplate.queryForList(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public PaginationResponse<Book> getByPage(int pageNumber, int pageSize,
			List<QueryCondition> cons) {
		String strSql = "select s1.*,IFNULL(s2.kucun,0) kucun from book s1  LEFT JOIN borrow_lab s2 on s2.book_id=s1.book_id";
		String countSql = "select count(*) from " + getTableName();
		// 总数
		int total = jdbcTemplate.queryForInt(countSql);
		if(cons.size()>0){
			strSql+=" where ";
			for (int i = 0; i < cons.size() - 1; i++) {
				strSql += cons.get(i).toString() + " and ";
			}
			strSql += cons.get(cons.size() - 1).toString();
		}
		strSql+=" order by updateTime";
		int endIndex = pageNumber + pageSize;
		strSql += " limit " + pageNumber + " , " + endIndex;

		List<Book> lists = new ArrayList<Book>();
		lists = jdbcTemplate.query(strSql, new RowMapper<Book>() {

			@Override
			public Book mapRow(ResultSet re, int arg1) throws SQLException {
				Book book = new Book();
				book.setBook_id(re.getString("book_id"));
				book.setAuthor(re.getString("author"));
				book.setBook_name(re.getString("book_name"));
				book.setInclude(re.getString("include"));
				book.setIntruduce(re.getString("intruduce"));
				book.setKucun(re.getInt("kucun"));
				book.setList(re.getString("list"));
				book.setOrder(re.getString("book_order"));
				book.setPrinter(re.getString("printer"));
				book.setPrint_time(re.getDate("print_time"));
				book.setUpdateTime(re.getDate("updateTime"));
				return book;
			}

		});
		PaginationResponse<Book> result = new PaginationResponse<Book>();
		result.setTotal(total);
		result.setRows(lists);
		return result;
	}

	@Override
	public PaginationResponse<HaveBorrowVO> getHaveBorrow(
			List<QueryCondition> cons,int pageNumber, int pageSize) {

		PaginationResponse<HaveBorrowVO> result = new PaginationResponse<>();
		StringBuffer strSql=new StringBuffer();
		strSql.append("SELECT s2.*,s3.book_name FROM	book s3,borrow_list s2  LEFT JOIN user_list s1 ON (	s1.user_id = s2.user_id	AND s1.Borrow_listnum1 = s2.borrow_listnum	OR s1.Borrow_listnum2 = s2.borrow_listnum	OR s1.Borrow_listnum3 = s2.borrow_listnum	OR s1.Borrow_listnum4 = s2.borrow_listnum	OR s1.Borrow_listnum5 = s2.borrow_listnum ) WHERE s3.book_id=s2.book_id and s1.user_id=s2.user_id");
		int endIndex = pageNumber + pageSize;
		strSql.append(" limit " + pageNumber + " , " + endIndex);
		String countSql ="select count(*) count FROM	book s3,borrow_list s2  LEFT JOIN user_list s1 ON (	s1.user_id = s2.user_id	AND s1.Borrow_listnum1 = s2.borrow_listnum	OR s1.Borrow_listnum2 = s2.borrow_listnum	OR s1.Borrow_listnum3 = s2.borrow_listnum	OR s1.Borrow_listnum4 = s2.borrow_listnum	OR s1.Borrow_listnum5 = s2.borrow_listnum ) WHERE s3.book_id=s2.book_id and s1.user_id=s2.user_id";
		int total = jdbcTemplate.queryForInt(countSql);
		List<Map<String, Object>> list = jdbcTemplate.queryForList(strSql.toString());
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
			ha.setBook_id((String) map.get("book_id"));
			ha.setUser_id((String) map.get("user_id"));
			listh.add(ha);
		}
		result.setRows(listh);
		return result;
	}

	
}
