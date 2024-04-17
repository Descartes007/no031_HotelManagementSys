package com.entity;

import com.util.VeDate;

public class Hist {
	private String histid = "H" + VeDate.getStringId();// 生成主键编号
	private String usersid;// 用户
	private String foodsid;// 食品
	private String num;// 浏览次数
	private String username;// 映射数据
	private String foodsname;// 映射数据

	public String getHistid() {
		return histid;
	}

	public void setHistid(String histid) {
		this.histid = histid;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getFoodsid() {
		return this.foodsid;
	}

	public void setFoodsid(String foodsid) {
		this.foodsid = foodsid;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFoodsname() {
		return this.foodsname;
	}

	public void setFoodsname(String foodsname) {
		this.foodsname = foodsname;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Hist [histid=" + this.histid + ", usersid=" + this.usersid + ", foodsid=" + this.foodsid + ", num="
				+ this.num + ", username=" + this.username + ", foodsname=" + this.foodsname + "]";
	}

}
