package com.bookmanger.userpage.vo;
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
		return "HaveBorrow [bookName=" + bookName + ", isdn=" + isdn
				+ ", return_time=" + return_time + ", remainingTime="
				+ remainingTime + "]";
	}
	
}
