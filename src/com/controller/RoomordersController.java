package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Roomorders;
import com.service.RoomordersService;
import com.entity.Users;
import com.entity.Rooms;
import com.service.UsersService;
import com.service.RoomsService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/roomorders", produces = "text/plain;charset=utf-8")
public class RoomordersController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private RoomordersService roomordersService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private RoomsService roomsService;

	// 准备添加数据
	@RequestMapping("createRoomorders.action")
	public String createRoomorders() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Rooms> roomsList = this.roomsService.getAllRooms();
		this.getRequest().setAttribute("roomsList", roomsList);
		return "admin/addroomorders";
	}

	// 添加数据
	@RequestMapping("addRoomorders.action")
	public String addRoomorders(Roomorders roomorders) {
		roomorders.setAddtime(VeDate.getStringDateShort());
		roomorders.setStatus("");
		this.roomordersService.insertRoomorders(roomorders);
		return "redirect:/roomorders/createRoomorders.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteRoomorders.action")
	public String deleteRoomorders(String id) {
		this.roomordersService.deleteRoomorders(id);
		return "redirect:/roomorders/getAllRoomorders.action";
	}

	// 批量删除数据
	@RequestMapping("deleteRoomordersByIds.action")
	public String deleteRoomordersByIds() {
		String[] ids = this.getRequest().getParameterValues("roomordersid");
		if (ids != null) {
			for (String roomordersid : ids) {
				this.roomordersService.deleteRoomorders(roomordersid);
			}
		}
		return "redirect:/roomorders/getAllRoomorders.action";
	}

	// 更新数据
	@RequestMapping("updateRoomorders.action")
	public String updateRoomorders(Roomorders roomorders) {
		this.roomordersService.updateRoomorders(roomorders);
		return "redirect:/roomorders/getAllRoomorders.action";
	}

	// 更新状态
	@RequestMapping("status.action")
	public String status(String id) {
		String status = "已付款";
		Roomorders roomorders = this.roomordersService.getRoomordersById(id);
		if (roomorders.getStatus().equals(status)) {
			status = "已入住";
			Rooms rooms = this.roomsService.getRoomsById(roomorders.getRoomsid());
			rooms.setStatus("已入住");
			this.roomsService.updateRooms(rooms);
		}
		if (roomorders.getStatus().equals("已入住")) {
			status = "已退房";
			Rooms rooms = this.roomsService.getRoomsById(roomorders.getRoomsid());
			rooms.setStatus("空闲");
			this.roomsService.updateRooms(rooms);
		}
		roomorders.setStatus(status);
		this.roomordersService.updateRoomorders(roomorders);
		return "redirect:/roomorders/getAllRoomorders.action";
	}

	// 显示全部数据
	@RequestMapping("getAllRoomorders.action")
	public String getAllRoomorders(String number) {
		List<Roomorders> roomordersList = this.roomordersService.getAllRoomorders();
		PageHelper.getUserPage(roomordersList, "roomorders", "getAllRoomorders", 10, number, this.getRequest());
		return "admin/listroomorders";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryRoomordersByCond.action")
	public String queryRoomordersByCond(String cond, String name, String number) {
		Roomorders roomorders = new Roomorders();
		if (cond != null) {
			if ("ordercode".equals(cond)) {
				roomorders.setOrdercode(name);
			}
			if ("usersid".equals(cond)) {
				roomorders.setUsersid(name);
			}
			if ("roomsid".equals(cond)) {
				roomorders.setRoomsid(name);
			}
			if ("addtime".equals(cond)) {
				roomorders.setAddtime(name);
			}
			if ("thestart".equals(cond)) {
				roomorders.setThestart(name);
			}
			if ("theend".equals(cond)) {
				roomorders.setTheend(name);
			}
			if ("status".equals(cond)) {
				roomorders.setStatus(name);
			}
			if ("memo".equals(cond)) {
				roomorders.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.roomordersService.getRoomordersByLike(roomorders), "roomorders", nameList, valueList,
				10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryroomorders";
	}

	// 按主键查询数据
	@RequestMapping("getRoomordersById.action")
	public String getRoomordersById(String id) {
		Roomorders roomorders = this.roomordersService.getRoomordersById(id);
		this.getRequest().setAttribute("roomorders", roomorders);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Rooms> roomsList = this.roomsService.getAllRooms();
		this.getRequest().setAttribute("roomsList", roomsList);
		return "admin/editroomorders";
	}

}
