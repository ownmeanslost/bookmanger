package com.bookmanger.common.model;

import java.util.Date;

public class Book {
	private String book_id;
	private String book_name;
	private String author;
	private String printer;
	private String order;
	private Date print_time;
	private String list;
	private String intruduce;
	private String Include;
	private Date updateTime;
	private int kucun;
	
	public int getKucun() {
		return kucun;
	}
	public void setKucun(int kucun) {
		this.kucun = kucun;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrinter() {
		return printer;
	}
	public void setPrinter(String printer) {
		this.printer = printer;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public Date getPrint_time() {
		return print_time;
	}
	public void setPrint_time(Date print_time) {
		this.print_time = print_time;
	}
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	public String getIntruduce() {
		return intruduce;
	}
	public void setIntruduce(String intruduce) {
		this.intruduce = intruduce;
	}
	public String getInclude() {
		return Include;
	}
	public void setInclude(String include) {
		Include = include;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name
				+ ", author=" + author + ", printer=" + printer + ", order="
				+ order + ", print_time=" + print_time + ", list=" + list
				+ ", intruduce=" + intruduce + ", Include=" + Include
				+ ", updateTime=" + updateTime + "]";
	}
	
}
