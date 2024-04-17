package com.entity;

import com.util.VeDate;

public class Booking {
	private String bookingid = "B" + VeDate.getStringId();// 生成主键编号
	private String bno;// 收支单号
	private String cate;// 收支类型
	private String reason;// 收支原因
	private String total;// 总计
	private String addtime;// 日期

	public String getBookingid() {
		return bookingid;
	}

	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}

	public String getBno() {
		return this.bno;
	}

	public void setBno(String bno) {
		this.bno = bno;
	}

	public String getCate() {
		return this.cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Booking [bookingid=" + this.bookingid + ", bno=" + this.bno + ", cate=" + this.cate + ", reason="
				+ this.reason + ", total=" + this.total + ", addtime=" + this.addtime + "]";
	}

}
