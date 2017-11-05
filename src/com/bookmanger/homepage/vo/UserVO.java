package com.bookmanger.homepage.vo;

public class UserVO {
	private String user_id;
	private String name;
	private String password;
	private String sex;
	private String id_num;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getId_num() {
		return id_num;
	}
	public void setId_num(String id_num) {
		this.id_num = id_num;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", password="
				+ password + ", sex=" + sex + ", id_num=" + id_num + "]";
	}
	
}
