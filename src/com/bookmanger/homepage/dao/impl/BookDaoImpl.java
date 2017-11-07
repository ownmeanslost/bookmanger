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
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;
import com.bookmanger.homepage.dao.BookDao;

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
		String strSql = "select s1.*,IFNULL(s2.kucun,0) kucun from book s1  LEFT JOIN borrow_lab s2 on s2.book_id=s1.book_id where ";
		String countSql = "select count(*) from " + getTableName();
		// 总数
		int total = jdbcTemplate.queryForInt(countSql);

		for (int i = 0; i < cons.size() - 1; i++) {
			strSql += cons.get(i).toString() + " and ";
		}
		strSql += cons.get(cons.size() - 1).toString();
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

}
