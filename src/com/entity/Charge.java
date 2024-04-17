package com.entity;

import com.util.VeDate;

public class Charge {
	private String chargeid = "C" + VeDate.getStringId();// 生成主键编号
	private String cno;// 消费单号
	private String ordersid;// 订单
	private String usersid;// 用户
	private String total;// 总计
	private String addtime;// 日期
	private String ordercode;// 映射数据
	private String username;// 映射数据

	public String getChargeid() {
		return chargeid;
	}

	public void setChargeid(String chargeid) {
		this.chargeid = chargeid;
	}

	public String getCno() {
		return this.cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
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

	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
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

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Charge [chargeid=" + this.chargeid + ", cno=" + this.cno + ", ordersid=" + this.ordersid + ", usersid="
				+ this.usersid + ", total=" + this.total + ", addtime=" + this.addtime + ", ordercode=" + this.ordercode
				+ ", username=" + this.username + "]";
	}

}
