package com.bookmanger.userpage.vo;

import java.sql.Date;



public class BorrowInfoVO {
	private String result;
	private Date returnTime;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	
}
