package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Needs;
import com.service.NeedsService;
import com.entity.Roomorders;
import com.entity.Rooms;
import com.entity.Users;
import com.service.RoomordersService;
import com.service.RoomsService;
import com.service.UsersService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/needs", produces = "text/plain;charset=utf-8")
public class NeedsController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private NeedsService needsService;
	@Autowired
	private RoomordersService roomordersService;
	@Autowired
	private RoomsService roomsService;
	@Autowired
	private UsersService usersService;

	// 准备添加数据
	@RequestMapping("createNeeds.action")
	public String createNeeds() {
		List<Roomorders> roomordersList = this.roomordersService.getAllRoomorders();
		this.getRequest().setAttribute("roomordersList", roomordersList);
		List<Rooms> roomsList = this.roomsService.getAllRooms();
		this.getRequest().setAttribute("roomsList", roomsList);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/addneeds";
	}

	// 添加数据
	@RequestMapping("addNeeds.action")
	public String addNeeds(Needs needs) {
		needs.setRoomordersid("");
		needs.setRoomsid("");
		needs.setUsersid("");
		needs.setAddtime(VeDate.getStringDateShort());
		needs.setStatus("");
		this.needsService.insertNeeds(needs);
		return "redirect:/needs/createNeeds.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteNeeds.action")
	public String deleteNeeds(String id) {
		this.needsService.deleteNeeds(id);
		return "redirect:/needs/getAllNeeds.action";
	}

	// 批量删除数据
	@RequestMapping("deleteNeedsByIds.action")
	public String deleteNeedsByIds() {
		String[] ids = this.getRequest().getParameterValues("needsid");
		if (ids != null) {
			for (String needsid : ids) {
				this.needsService.deleteNeeds(needsid);
			}
		}
		return "redirect:/needs/getAllNeeds.action";
	}

	// 更新数据
	@RequestMapping("updateNeeds.action")
	public String updateNeeds(Needs needs) {
		this.needsService.updateNeeds(needs);
		return "redirect:/needs/getAllNeeds.action";
	}

	// 更新状态
	@RequestMapping("status.action")
	public String status(String id) {
		String status = "";
		Needs needs = this.needsService.getNeedsById(id);
		if (status.equals(needs.getStatus())) {
			status = "";
		}
		needs.setStatus(status);
		this.needsService.updateNeeds(needs);
		return "redirect:/needs/getAllNeeds.action";
	}

	// 显示全部数据
	@RequestMapping("getAllNeeds.action")
	public String getAllNeeds(String number) {
		List<Needs> needsList = this.needsService.getAllNeeds();
		PageHelper.getUserPage(needsList, "needs", "getAllNeeds", 10, number, this.getRequest());
		return "admin/listneeds";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryNeedsByCond.action")
	public String queryNeedsByCond(String cond, String name, String number) {
		Needs needs = new Needs();
		if (cond != null) {
			if ("roomordersid".equals(cond)) {
				needs.setRoomordersid(name);
			}
			if ("roomsid".equals(cond)) {
				needs.setRoomsid(name);
			}
			if ("usersid".equals(cond)) {
				needs.setUsersid(name);
			}
			if ("goodsname".equals(cond)) {
				needs.setGoodsname(name);
			}
			if ("addtime".equals(cond)) {
				needs.setAddtime(name);
			}
			if ("status".equals(cond)) {
				needs.setStatus(name);
			}
			if ("reps".equals(cond)) {
				needs.setReps(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.needsService.getNeedsByLike(needs), "needs", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryneeds";
	}

	// 按主键查询数据
	@RequestMapping("getNeedsById.action")
	public String getNeedsById(String id) {
		Needs needs = this.needsService.getNeedsById(id);
		this.getRequest().setAttribute("needs", needs);
		List<Roomorders> roomordersList = this.roomordersService.getAllRoomorders();
		this.getRequest().setAttribute("roomordersList", roomordersList);
		List<Rooms> roomsList = this.roomsService.getAllRooms();
		this.getRequest().setAttribute("roomsList", roomsList);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/editneeds";
	}

}
