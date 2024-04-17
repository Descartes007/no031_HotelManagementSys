package com.entity;

import com.util.VeDate;

public class Cart {
	private String cartid = "C" + VeDate.getStringId();// 生成主键编号
	private String usersid;// 用户
	private String foodsid;// 食品
	private String price;// 单价
	private String num;// 数量
	private String addtime;// 加入日期
	private String username;// 映射数据
	private String foodsname;// 映射数据
	private String image;// 映射数据

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCartid() {
		return cartid;
	}

	public void setCartid(String cartid) {
		this.cartid = cartid;
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

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
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
		return "Cart [cartid=" + this.cartid + ", usersid=" + this.usersid + ", foodsid=" + this.foodsid + ", price="
				+ this.price + ", num=" + this.num + ", addtime=" + this.addtime + ", username=" + this.username
				+ ", foodsname=" + this.foodsname + "]";
	}

}
