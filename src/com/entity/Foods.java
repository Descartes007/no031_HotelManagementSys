package com.entity;

import com.util.VeDate;

public class Foods {
	private String foodsid = "F" + VeDate.getStringId();// 生成主键编号
	private String foodsname;// 食品名称
	private String image;// 食品图片
	private String cateid;// 食品类型
	private String price;// 食品单价
	private String recommend;// 是否推荐
	private String addtime;// 上架日期
	private String hits;// 点击数
	private String sellnum;// 销量
	private String contents;// 食品介绍
	private String catename;// 映射数据

	public String getFoodsid() {
		return foodsid;
	}

	public void setFoodsid(String foodsid) {
		this.foodsid = foodsid;
	}

	public String getFoodsname() {
		return this.foodsname;
	}

	public void setFoodsname(String foodsname) {
		this.foodsname = foodsname;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCateid() {
		return this.cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRecommend() {
		return this.recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getHits() {
		return this.hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}

	public String getSellnum() {
		return this.sellnum;
	}

	public void setSellnum(String sellnum) {
		this.sellnum = sellnum;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Foods [foodsid=" + this.foodsid + ", foodsname=" + this.foodsname + ", image=" + this.image
				+ ", cateid=" + this.cateid + ", price=" + this.price + ", recommend=" + this.recommend + ", addtime="
				+ this.addtime + ", hits=" + this.hits + ", sellnum=" + this.sellnum + ", contents=" + this.contents
				+ ", catename=" + this.catename + "]";
	}

}
