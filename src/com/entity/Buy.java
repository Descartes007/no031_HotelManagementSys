package com.entity;

import com.util.VeDate;

public class Buy {
	private String buyid = "B" + VeDate.getStringId();// 生成主键编号
	private String bno;// 采购单号
	private String goodsname;// 采购货物
	private String price;// 采购单价
	private String num;// 采购数量
	private String total;// 总计
	private String addtime;// 采购日期
	private String manager;// 经手人
	private String memo;// 备注

	public String getBuyid() {
		return buyid;
	}

	public void setBuyid(String buyid) {
		this.buyid = buyid;
	}

	public String getBno() {
		return this.bno;
	}

	public void setBno(String bno) {
		this.bno = bno;
	}

	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
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

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Buy [buyid=" + this.buyid + ", bno=" + this.bno + ", goodsname=" + this.goodsname + ", price="
				+ this.price + ", num=" + this.num + ", total=" + this.total + ", addtime=" + this.addtime
				+ ", manager=" + this.manager + ", memo=" + this.memo + "]";
	}

}
