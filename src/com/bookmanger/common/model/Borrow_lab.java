package com.bookmanger.common.model;

import java.util.Date;
/**
 * 
 * @author 李少凡
 *
 */
public class Borrow_lab {
	private String bookid;
	private int kucun;
	private Date return_time;
	
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public int getKucun() {
		return kucun;
	}
	public void setKucun(int kucun) {
		this.kucun = kucun;
	}
	public Date getReturn_time() {
		return return_time;
	}
	public void setReturn_time(Date return_time) {
		this.return_time = return_time;
	}
	@Override
	public String toString() {
		return "Borrow_lab [bookid=" + bookid + ", kucun=" + kucun
				+ ", return_time=" + return_time + "]";
	}
	
}
