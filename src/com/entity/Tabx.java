package com.entity;

import com.util.VeDate;

public class Tabx {
	private String tabxid = "T" + VeDate.getStringId();// 生成主键编号
	private String tabxname;// 餐桌名称
	private String image;// 图片
	private String num;// 用餐人数
	private String cate;// 餐桌类型
	private String place;// 餐桌位置
	private String addtime;// 创建日期
	private String contents;// 餐桌介绍

	public String getTabxid() {
		return tabxid;
	}

	public void setTabxid(String tabxid) {
		this.tabxid = tabxid;
	}

	public String getTabxname() {
		return this.tabxname;
	}

	public void setTabxname(String tabxname) {
		this.tabxname = tabxname;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCate() {
		return this.cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
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
		return "Tabx [tabxid=" + this.tabxid + ", tabxname=" + this.tabxname + ", image=" + this.image + ", num="
				+ this.num + ", cate=" + this.cate + ", place=" + this.place + ", addtime=" + this.addtime
				+ ", contents=" + this.contents + "]";
	}

}
