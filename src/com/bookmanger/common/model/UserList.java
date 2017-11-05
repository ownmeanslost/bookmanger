package com.bookmanger.common.model;

import java.util.Date;
/**
 * 读者借阅清单
 * @author 李少凡
 *
 */
public class UserList {
	private String user_id;
	private int borrow_num;
	private Date return_time;
	private Integer borrow_listnum1;
	private Integer borrow_listnum2;
	private Integer borrow_listnum3;
	private Integer borrow_listnum4;
	private Integer borrow_listnum5;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getBorrow_num() {
		return borrow_num;
	}
	public void setBorrow_num(int borrow_num) {
		this.borrow_num = borrow_num;
	}
	public Date getReturn_time() {
		return return_time;
	}
	public void setReturn_time(Date return_time) {
		this.return_time = return_time;
	}
	public Integer getBorrow_listnum1() {
		return borrow_listnum1;
	}
	public void setBorrow_listnum1(Integer borrow_listnum1) {
		this.borrow_listnum1 = borrow_listnum1;
	}
	public Integer getBorrow_listnum2() {
		return borrow_listnum2;
	}
	public void setBorrow_listnum2(Integer borrow_listnum2) {
		this.borrow_listnum2 = borrow_listnum2;
	}
	public Integer getBorrow_listnum3() {
		return borrow_listnum3;
	}
	public void setBorrow_listnum3(Integer borrow_listnum3) {
		this.borrow_listnum3 = borrow_listnum3;
	}
	public Integer getBorrow_listnum4() {
		return borrow_listnum4;
	}
	public void setBorrow_listnum4(Integer borrow_listnum4) {
		this.borrow_listnum4 = borrow_listnum4;
	}
	public Integer getBorrow_listnum5() {
		return borrow_listnum5;
	}
	public void setBorrow_listnum5(Integer borrow_listnum5) {
		this.borrow_listnum5 = borrow_listnum5;
	}
	/**
	 * 找出为NULL的列
	 * @param str
	 * @return
	 */
	public Integer isNullBorrowListNum(String str){
		switch (str) {
		case "borrow_listnum1":
			return this.borrow_listnum1;
		case "borrow_listnum2":
			return this.borrow_listnum2;
		case "borrow_listnum3":
			return this.borrow_listnum3;
		case "borrow_listnum4":
			return this.borrow_listnum4;
		case "borrow_listnum5":
			return this.borrow_listnum5;
			default:
				return null;
		}
	}
	/**
	 * 给某个borrow_listnum赋值
	 * @param borrow_listnum
	 */
	public void setBorrow_list(String name,Integer borrow_listnum){
		switch (name) {
		case "borrow_listnum1":
			 this.borrow_listnum1=borrow_listnum;
			 break;
		case "borrow_listnum2":
			this.borrow_listnum2=borrow_listnum;
			break;
		case "borrow_listnum3":
			 this.borrow_listnum3=borrow_listnum;
			 break;
		case "borrow_listnum4":
			 this.borrow_listnum4=borrow_listnum;
			 break;
		case "borrow_listnum5":
			this.borrow_listnum5=borrow_listnum;
			break;
		}
	}
}
