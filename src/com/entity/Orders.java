package com.entity;

import com.util.VeDate;

public class Orders {
	private String ordersid = "O" + VeDate.getStringId();// 生成主键编号
	private String ordercode;// 订单号
	private String usersid;// 用户
	private String employid;// 服务员
	private String total;// 总计
	private String addtime;// 下单日期
	private String status;// 状态
	private String tabxid;// 餐桌
	private String orderdate;// 预定日期
	private String sectionx;// 时间段
	private String username;// 映射数据
	private String employname;// 映射数据
	private String tabxname;// 映射数据

	public String getOrdersid() {
		return ordersid;
	}

	public void setOrdersid(String ordersid) {
		this.ordersid = ordersid;
	}

	public String getOrdercode() {
		return this.ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getEmployid() {
		return this.employid;
	}

	public void setEmployid(String employid) {
		this.employid = employid;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTabxid() {
		return this.tabxid;
	}

	public void setTabxid(String tabxid) {
		this.tabxid = tabxid;
	}

	public String getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getSectionx() {
		return this.sectionx;
	}

	public void setSectionx(String sectionx) {
		this.sectionx = sectionx;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmployname() {
		return this.employname;
	}

	public void setEmployname(String employname) {
		this.employname = employname;
	}

	public String getTabxname() {
		return this.tabxname;
	}

	public void setTabxname(String tabxname) {
		this.tabxname = tabxname;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Orders [ordersid=" + this.ordersid + ", ordercode=" + this.ordercode + ", usersid=" + this.usersid
				+ ", employid=" + this.employid + ", total=" + this.total + ", addtime=" + this.addtime + ", status="
				+ this.status + ", tabxid=" + this.tabxid + ", orderdate=" + this.orderdate + ", sectionx="
				+ this.sectionx + ", username=" + this.username + ", employname=" + this.employname + ", tabxname="
				+ this.tabxname + "]";
	}

}
