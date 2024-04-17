package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Tabx;
import com.service.TabxService;
import com.util.PageHelper;
import com.util.VeDate;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/tabx" , produces = "text/plain;charset=utf-8")
public class TabxController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private TabxService tabxService;

	// 准备添加数据
	@RequestMapping("createTabx.action")
	public String createTabx() {
		return "admin/addtabx";
	}
	// 添加数据
	@RequestMapping("addTabx.action")
	public String addTabx(Tabx tabx) {
		tabx.setAddtime(VeDate.getStringDateShort());
		this.tabxService.insertTabx(tabx);
		return "redirect:/tabx/createTabx.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteTabx.action")
	public String deleteTabx(String id) {
		this.tabxService.deleteTabx(id);
		return "redirect:/tabx/getAllTabx.action";
	}

	// 批量删除数据
	@RequestMapping("deleteTabxByIds.action")
	public String deleteTabxByIds() {
		String[] ids = this.getRequest().getParameterValues("tabxid");
		if (ids != null) {
			for (String tabxid : ids) {
				this.tabxService.deleteTabx(tabxid);
			}
		}
		return "redirect:/tabx/getAllTabx.action";
	}

	// 更新数据
	@RequestMapping("updateTabx.action")
	public String updateTabx(Tabx tabx) {
		this.tabxService.updateTabx(tabx);
		return "redirect:/tabx/getAllTabx.action";
	}

	// 显示全部数据
	@RequestMapping("getAllTabx.action")
	public String getAllTabx(String number) {
		List<Tabx> tabxList = this.tabxService.getAllTabx();
		PageHelper.getPage(tabxList, "tabx", null, null, 10, number, this.getRequest(), null);
		return "admin/listtabx";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryTabxByCond.action")
	public String queryTabxByCond(String cond, String name, String number) {
		Tabx tabx = new Tabx();
		if(cond != null){
			if ("tabxname".equals(cond)) {
				tabx.setTabxname(name);
			}
			if ("image".equals(cond)) {
				tabx.setImage(name);
			}
			if ("num".equals(cond)) {
				tabx.setNum(name);
			}
			if ("cate".equals(cond)) {
				tabx.setCate(name);
			}
			if ("place".equals(cond)) {
				tabx.setPlace(name);
			}
			if ("addtime".equals(cond)) {
				tabx.setAddtime(name);
			}
			if ("contents".equals(cond)) {
				tabx.setContents(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.tabxService.getTabxByLike(tabx), "tabx", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querytabx";
	}

	// 按主键查询数据
	@RequestMapping("getTabxById.action")
	public String getTabxById(String id) {
		Tabx tabx = this.tabxService.getTabxById(id);
		this.getRequest().setAttribute("tabx", tabx);
		return "admin/edittabx";
	}


}
