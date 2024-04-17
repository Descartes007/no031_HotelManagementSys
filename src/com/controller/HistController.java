package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Hist;
import com.service.HistService;
import com.entity.Users;
import com.entity.Foods;
import com.service.UsersService;
import com.service.FoodsService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/hist", produces = "text/plain;charset=utf-8")
public class HistController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private HistService histService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private FoodsService foodsService;

	// 准备添加数据
	@RequestMapping("createHist.action")
	public String createHist() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Foods> foodsList = this.foodsService.getAllFoods();
		this.getRequest().setAttribute("foodsList", foodsList);
		return "admin/addhist";
	}

	// 添加数据
	@RequestMapping("addHist.action")
	public String addHist(Hist hist) {
		this.histService.insertHist(hist);
		return "redirect:/hist/createHist.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteHist.action")
	public String deleteHist(String id) {
		this.histService.deleteHist(id);
		return "redirect:/hist/getAllHist.action";
	}

	// 批量删除数据
	@RequestMapping("deleteHistByIds.action")
	public String deleteHistByIds() {
		String[] ids = this.getRequest().getParameterValues("histid");
		if (ids != null) {
			for (String histid : ids) {
				this.histService.deleteHist(histid);
			}
		}
		return "redirect:/hist/getAllHist.action";
	}

	// 更新数据
	@RequestMapping("updateHist.action")
	public String updateHist(Hist hist) {
		this.histService.updateHist(hist);
		return "redirect:/hist/getAllHist.action";
	}

	// 显示全部数据
	@RequestMapping("getAllHist.action")
	public String getAllHist(String number) {
		List<Hist> histList = this.histService.getAllHist();
		PageHelper.getUserPage(histList, "hist", "getAllHist", 10, number, this.getRequest());
		return "admin/listhist";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryHistByCond.action")
	public String queryHistByCond(String cond, String name, String number) {
		Hist hist = new Hist();
		if (cond != null) {
			if ("usersid".equals(cond)) {
				hist.setUsersid(name);
			}
			if ("foodsid".equals(cond)) {
				hist.setFoodsid(name);
			}
			if ("num".equals(cond)) {
				hist.setNum(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.histService.getHistByLike(hist), "hist", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryhist";
	}

	// 按主键查询数据
	@RequestMapping("getHistById.action")
	public String getHistById(String id) {
		Hist hist = this.histService.getHistById(id);
		this.getRequest().setAttribute("hist", hist);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Foods> foodsList = this.foodsService.getAllFoods();
		this.getRequest().setAttribute("foodsList", foodsList);
		return "admin/edithist";
	}

}
