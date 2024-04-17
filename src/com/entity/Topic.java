package com.entity;

import com.util.VeDate;

public class Topic {
	private String topicid = "T" + VeDate.getStringId();// 生成主键编号
	private String ordersid;// 订单
	private String usersid;// 用户
	private String foodsid;// 食品
	private String num;// 评分
	private String contents;// 内容
	private String addtime;// 日期
	private String ordercode;// 映射数据
	private String username;// 映射数据
	private String foodsname;// 映射数据

	public String getTopicid() {
		return topicid;
	}

	public void setTopicid(String topicid) {
		this.topicid = topicid;
	}

	public String getOrdersid() {
		return this.ordersid;
	}

	public void setOrdersid(String ordersid) {
		this.ordersid = ordersid;
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

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getOrdercode() {
		return this.ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
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
		return "Topic [topicid=" + this.topicid + ", ordersid=" + this.ordersid + ", usersid=" + this.usersid
				+ ", foodsid=" + this.foodsid + ", num=" + this.num + ", contents=" + this.contents + ", addtime="
				+ this.addtime + ", ordercode=" + this.ordercode + ", username=" + this.username + ", foodsname="
				+ this.foodsname + "]";
	}

}
