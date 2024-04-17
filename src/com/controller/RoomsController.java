package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Rooms;
import com.service.RoomsService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/rooms", produces = "text/plain;charset=utf-8")
public class RoomsController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private RoomsService roomsService;

	// 准备添加数据
	@RequestMapping("createRooms.action")
	public String createRooms() {
		return "admin/addrooms";
	}

	// 添加数据
	@RequestMapping("addRooms.action")
	public String addRooms(Rooms rooms) {
		rooms.setStatus("空闲");
		rooms.setHits("0");
		this.roomsService.insertRooms(rooms);
		return "redirect:/rooms/createRooms.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteRooms.action")
	public String deleteRooms(String id) {
		this.roomsService.deleteRooms(id);
		return "redirect:/rooms/getAllRooms.action";
	}

	// 批量删除数据
	@RequestMapping("deleteRoomsByIds.action")
	public String deleteRoomsByIds() {
		String[] ids = this.getRequest().getParameterValues("roomsid");
		if (ids != null) {
			for (String roomsid : ids) {
				this.roomsService.deleteRooms(roomsid);
			}
		}
		return "redirect:/rooms/getAllRooms.action";
	}

	// 更新数据
	@RequestMapping("updateRooms.action")
	public String updateRooms(Rooms rooms) {
		this.roomsService.updateRooms(rooms);
		return "redirect:/rooms/getAllRooms.action";
	}

	// 更新状态
	@RequestMapping("status.action")
	public String status(String id) {
		String status = "";
		Rooms rooms = this.roomsService.getRoomsById(id);
		if (status.equals(rooms.getStatus())) {
			status = "";
		}
		rooms.setStatus(status);
		this.roomsService.updateRooms(rooms);
		return "redirect:/rooms/getAllRooms.action";
	}

	// 显示全部数据
	@RequestMapping("getAllRooms.action")
	public String getAllRooms(String number) {
		List<Rooms> roomsList = this.roomsService.getAllRooms();
		PageHelper.getUserPage(roomsList, "rooms", "getAllRooms", 10, number, this.getRequest());
		return "admin/listrooms";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryRoomsByCond.action")
	public String queryRoomsByCond(String cond, String name, String number) {
		Rooms rooms = new Rooms();
		if (cond != null) {
			if ("roomsno".equals(cond)) {
				rooms.setRoomsno(name);
			}
			if ("cate".equals(cond)) {
				rooms.setCate(name);
			}
			if ("image".equals(cond)) {
				rooms.setImage(name);
			}
			if ("price".equals(cond)) {
				rooms.setPrice(name);
			}
			if ("mianji".equals(cond)) {
				rooms.setMianji(name);
			}
			if ("chaoxiang".equals(cond)) {
				rooms.setChaoxiang(name);
			}
			if ("status".equals(cond)) {
				rooms.setStatus(name);
			}
			if ("hits".equals(cond)) {
				rooms.setHits(name);
			}
			if ("contents".equals(cond)) {
				rooms.setContents(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.roomsService.getRoomsByLike(rooms), "rooms", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryrooms";
	}

	// 按主键查询数据
	@RequestMapping("getRoomsById.action")
	public String getRoomsById(String id) {
		Rooms rooms = this.roomsService.getRoomsById(id);
		this.getRequest().setAttribute("rooms", rooms);
		return "admin/editrooms";
	}

}
