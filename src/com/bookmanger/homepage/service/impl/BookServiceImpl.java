package com.bookmanger.homepage.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmanger.common.model.Book;
import com.bookmanger.common.utils.PaginationResponse;
import com.bookmanger.common.utils.QueryCondition;
import com.bookmanger.homepage.dao.BookDao;
import com.bookmanger.homepage.service.BookService;
import com.bookmanger.homepage.vo.BookVO;
import com.bookmanger.homepage.vo.HaveBorrowVO;

public class BookServiceImpl implements BookService{

	@Autowired
	BookDao bookDao;
	@Override
	public BookVO findOneBook(String ISDN) {
		List<Map<String,Object>> list=bookDao.findBook(ISDN);
		BookVO book=new BookVO();
		if(list!=null&&!list.isEmpty()){
			book.setBook_id(list.get(0).get("book_id").toString());
			book.setBook_name(list.get(0).get("book_name").toString());
			book.setAuthor(list.get(0).get("author").toString());
			book.setInclude(list.get(0).get("include").toString());
			book.setIntruduce(list.get(0).get("intruduce").toString());
			book.setKucun(list.get(0).get("kucun").toString());
			book.setList(list.get(0).get("list").toString());
			book.setOrder(list.get(0).get("book_order").toString());
			book.setPrint_time(list.get(0).get("print_time").toString());
			book.setPrinter(list.get(0).get("printer").toString());
			
		}
		return book;
	}
	@Override
	public PaginationResponse<Book> getBookList(String pageNumber, String pageSize,
			List<QueryCondition> cons) {
		return bookDao.getByPage(Integer.parseInt(pageNumber),Integer.parseInt(pageSize), cons);
		
		
	}

	@Override
	public PaginationResponse<HaveBorrowVO> getHaveExpire(
			List<QueryCondition> cons,String pageNumber, String pageSize) {
		PaginationResponse<HaveBorrowVO> pa=bookDao.getHaveBorrow(cons,Integer.parseInt(pageNumber),Integer.parseInt(pageSize));
		// 删除借阅天数大于等于0的
		for (int i = 0; i < pa.getRows().size(); i++) {
			if (Integer.parseInt((pa.getRows().get(i).getRemainingTime())) >= 0) {
				pa.getRows().remove(i);
				i = i - 1;
				pa.setTotal(pa.getTotal() - 1);
			}

		}
		return pa;
	}
	
}
