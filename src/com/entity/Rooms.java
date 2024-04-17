package com.entity;

import com.util.VeDate;

public class Rooms {
	private String roomsid = "R" + VeDate.getStringId();// 生成主键编号
	private String roomsno;// 房间号
	private String cate;// 客房类型
	private String image;// 客房图片
	private String price;// 客房价格
	private String mianji;// 客房面积
	private String chaoxiang;// 客房朝向
	private String status;// 客房状态
	private String hits;// 点击数
	private String contents;// 客房介绍

	public String getRoomsid() {
		return roomsid;
	}

	public void setRoomsid(String roomsid) {
		this.roomsid = roomsid;
	}

	public String getRoomsno() {
		return this.roomsno;
	}

	public void setRoomsno(String roomsno) {
		this.roomsno = roomsno;
	}

	public String getCate() {
		return this.cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMianji() {
		return this.mianji;
	}

	public void setMianji(String mianji) {
		this.mianji = mianji;
	}

	public String getChaoxiang() {
		return this.chaoxiang;
	}

	public void setChaoxiang(String chaoxiang) {
		this.chaoxiang = chaoxiang;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHits() {
		return this.hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Rooms [roomsid=" + this.roomsid + ", roomsno=" + this.roomsno + ", cate=" + this.cate + ", image="
				+ this.image + ", price=" + this.price + ", mianji=" + this.mianji + ", chaoxiang=" + this.chaoxiang
				+ ", status=" + this.status + ", hits=" + this.hits + ", contents=" + this.contents + "]";
	}

}
