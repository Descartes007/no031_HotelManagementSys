package com.entity;

import com.util.VeDate;

public class Roomorders {
	private String roomordersid = "R" + VeDate.getStringId();// 生成主键编号
	private String ordercode;// 订单号
	private String usersid;// 用户
	private String roomsid;// 客房
	private String addtime;// 下单日期
	private String thestart;// 开始日期
	private String theend;// 结束日期
	private String status;// 状态
	private String memo;// 备注
	private String username;// 映射数据
	private String roomsno;// 映射数据
	private String total;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getRoomordersid() {
		return roomordersid;
	}

	public void setRoomordersid(String roomordersid) {
		this.roomordersid = roomordersid;
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

	public String getRoomsid() {
		return this.roomsid;
	}

	public void setRoomsid(String roomsid) {
		this.roomsid = roomsid;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getThestart() {
		return this.thestart;
	}

	public void setThestart(String thestart) {
		this.thestart = thestart;
	}

	public String getTheend() {
		return this.theend;
	}

	public void setTheend(String theend) {
		this.theend = theend;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoomsno() {
		return this.roomsno;
	}

	public void setRoomsno(String roomsno) {
		this.roomsno = roomsno;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Roomorders [roomordersid=" + this.roomordersid + ", ordercode=" + this.ordercode + ", usersid="
				+ this.usersid + ", roomsid=" + this.roomsid + ", addtime=" + this.addtime + ", thestart="
				+ this.thestart + ", theend=" + this.theend + ", status=" + this.status + ", memo=" + this.memo
				+ ", username=" + this.username + ", roomsno=" + this.roomsno + "]";
	}

}
