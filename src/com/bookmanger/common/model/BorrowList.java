package com.bookmanger.common.model;

import java.util.Date;

public class BorrowList {
	private int borrow_listnum;
	private String user_id;
	private String book_id;
	private Date borrow_time;
	private Date return_time;
	public int getBorrow_listnum() {
		return borrow_listnum;
	}
	public void setBorrow_listnum(int borrow_listnum) {
		this.borrow_listnum = borrow_listnum;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public Date getBorrow_time() {
		return borrow_time;
	}
	public void setBorrow_time(Date borrow_time) {
		this.borrow_time = borrow_time;
	}
	public Date getReturn_time() {
		return return_time;
	}
	public void setReturn_time(Date return_time) {
		this.return_time = return_time;
	}
	@Override
	public String toString() {
		return "BorrowList [borrow_listnum=" + borrow_listnum + ", user_id="
				+ user_id + ", book_id=" + book_id + ", borrow_time="
				+ borrow_time + ", return_time=" + return_time + "]";
	}
	
}
