package com.entity;

import com.util.VeDate;

public class Needs {
	private String needsid = "N" + VeDate.getStringId();// 生成主键编号
	private String roomordersid;// 订单号
	private String roomsid;// 客房
	private String usersid;// 用户
	private String goodsname;// 需求
	private String addtime;// 日期
	private String status;// 状态
	private String reps;// 管理员回复
	private String ordercode;// 映射数据
	private String roomsno;// 映射数据
	private String username;// 映射数据

	public String getNeedsid() {
		return needsid;
	}

	public void setNeedsid(String needsid) {
		this.needsid = needsid;
	}

	public String getRoomordersid() {
		return this.roomordersid;
	}

	public void setRoomordersid(String roomordersid) {
		this.roomordersid = roomordersid;
	}

	public String getRoomsid() {
		return this.roomsid;
	}

	public void setRoomsid(String roomsid) {
		this.roomsid = roomsid;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
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

	public String getReps() {
		return this.reps;
	}

	public void setReps(String reps) {
		this.reps = reps;
	}

	public String getOrdercode() {
		return this.ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public String getRoomsno() {
		return this.roomsno;
	}

	public void setRoomsno(String roomsno) {
		this.roomsno = roomsno;
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
		return "Needs [needsid=" + this.needsid + ", roomordersid=" + this.roomordersid + ", roomsid=" + this.roomsid
				+ ", usersid=" + this.usersid + ", goodsname=" + this.goodsname + ", addtime=" + this.addtime
				+ ", status=" + this.status + ", reps=" + this.reps + ", ordercode=" + this.ordercode + ", roomsno="
				+ this.roomsno + ", username=" + this.username + "]";
	}

}
