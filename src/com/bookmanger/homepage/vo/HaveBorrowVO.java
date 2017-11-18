package com.bookmanger.homepage.vo;
/**
 * 以借阅图书
 * @author 李少凡
 *
 */
public class HaveBorrowVO {
	private String bookName;
	private String isdn;
	private String return_time;
	private String remainingTime;
	private String user_id;
	private String book_id;
	
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

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getIsdn() {
		return isdn;
	}

	public void setIsdn(String isdn) {
		this.isdn = isdn;
	}

	public String getReturn_time() {
		return return_time;
	}

	public void setReturn_time(String return_time) {
		this.return_time = return_time;
	}

	public String getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(String remainingTime) {
		this.remainingTime = remainingTime;
	}

	@Override
	public String toString() {
		return "HaveBorrowVO [bookName=" + bookName + ", isdn=" + isdn
				+ ", return_time=" + return_time + ", remainingTime="
				+ remainingTime + ", user_id=" + user_id + ", book_id="
				+ book_id + "]";
	}


	
}
