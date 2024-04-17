package com.entity;

import com.util.VeDate;

public class Details {
	private String detailsid = "D" + VeDate.getStringId();// 生成主键编号
	private String ordersid;// 订单
	private String foodsid;// 食品
	private String price;// 单价
	private String num;// 数量
	private String memo;// 备注
	private String ordercode;// 映射数据
	private String foodsname;// 映射数据

	public String getDetailsid() {
		return detailsid;
	}

	public void setDetailsid(String detailsid) {
		this.detailsid = detailsid;
	}

	public String getOrdersid() {
		return this.ordersid;
	}

	public void setOrdersid(String ordersid) {
		this.ordersid = ordersid;
	}

	public String getFoodsid() {
		return this.foodsid;
	}

	public void setFoodsid(String foodsid) {
		this.foodsid = foodsid;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getOrdercode() {
		return this.ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
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
		return "Details [detailsid=" + this.detailsid + ", ordersid=" + this.ordersid + ", foodsid=" + this.foodsid
				+ ", price=" + this.price + ", num=" + this.num + ", memo=" + this.memo + ", ordercode="
				+ this.ordercode + ", foodsname=" + this.foodsname + "]";
	}

}
