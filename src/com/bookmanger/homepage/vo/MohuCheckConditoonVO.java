package com.bookmanger.homepage.vo;


public class MohuCheckConditoonVO {
	private String book_name;
	private String author;
	private String printer;
	private String include;
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
	public String getInclude() {
		return include;
	}
	public void setInclude(String include) {
		this.include = include;
	}
	@Override
	public String toString() {
		return "MohuCheckConditoon [book_name=" + book_name + ", author="
				+ author + ", printer=" + printer + ", include=" + include
				+ "]";
	}
	
}
