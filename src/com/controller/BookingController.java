package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Booking;
import com.service.BookingService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/booking", produces = "text/plain;charset=utf-8")
public class BookingController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private BookingService bookingService;

	// 准备添加数据
	@RequestMapping("createBooking.action")
	public String createBooking() {
		return "admin/addbooking";
	}

	// 添加数据
	@RequestMapping("addBooking.action")
	public String addBooking(Booking booking) {
		this.bookingService.insertBooking(booking);
		return "redirect:/booking/createBooking.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteBooking.action")
	public String deleteBooking(String id) {
		this.bookingService.deleteBooking(id);
		return "redirect:/booking/getAllBooking.action";
	}

	// 批量删除数据
	@RequestMapping("deleteBookingByIds.action")
	public String deleteBookingByIds() {
		String[] ids = this.getRequest().getParameterValues("bookingid");
		if (ids != null) {
			for (String bookingid : ids) {
				this.bookingService.deleteBooking(bookingid);
			}
		}
		return "redirect:/booking/getAllBooking.action";
	}

	// 更新数据
	@RequestMapping("updateBooking.action")
	public String updateBooking(Booking booking) {
		this.bookingService.updateBooking(booking);
		return "redirect:/booking/getAllBooking.action";
	}

	// 显示全部数据
	@RequestMapping("getAllBooking.action")
	public String getAllBooking(String number) {
		List<Booking> bookingList = this.bookingService.getAllBooking();
		PageHelper.getUserPage(bookingList, "booking", "getAllBooking", 10, number, this.getRequest());
		return "admin/listbooking";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryBookingByCond.action")
	public String queryBookingByCond(String cond, String name, String number) {
		Booking booking = new Booking();
		if (cond != null) {
			if ("bno".equals(cond)) {
				booking.setBno(name);
			}
			if ("cate".equals(cond)) {
				booking.setCate(name);
			}
			if ("reason".equals(cond)) {
				booking.setReason(name);
			}
			if ("total".equals(cond)) {
				booking.setTotal(name);
			}
			if ("addtime".equals(cond)) {
				booking.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.bookingService.getBookingByLike(booking), "booking", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querybooking";
	}

	// 按主键查询数据
	@RequestMapping("getBookingById.action")
	public String getBookingById(String id) {
		Booking booking = this.bookingService.getBookingById(id);
		this.getRequest().setAttribute("booking", booking);
		return "admin/editbooking";
	}

}
