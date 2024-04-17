package com.entity;

import com.util.VeDate;

public class Employ {
	private String employid = "E" + VeDate.getStringId();// 生成主键编号
	private String eno;// 员工号
	private String password;
	private String employname;// 姓名
	private String sex;// 性别
	private String birthday;// 出生日期
	private String jiguan;// 籍贯
	private String idcard;// 身份证
	private String salary;// 薪资
	private String contact;// 联系方式
	private String status;// 状态
	private String addtime;// 创建日期

	public String getEmployid() {
		return employid;
	}

	public void setEmployid(String employid) {
		this.employid = employid;
	}

	public String getEno() {
		return this.eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getEmployname() {
		return this.employname;
	}

	public void setEmployname(String employname) {
		this.employname = employname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getJiguan() {
		return this.jiguan;
	}

	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Employ [employid=" + this.employid + ", eno=" + this.eno + ", employname=" + this.employname + ", sex="
				+ this.sex + ", birthday=" + this.birthday + ", jiguan=" + this.jiguan + ", idcard=" + this.idcard
				+ ", salary=" + this.salary + ", contact=" + this.contact + ", status=" + this.status + ", addtime="
				+ this.addtime + "]";
	}

}
