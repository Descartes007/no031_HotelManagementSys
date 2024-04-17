package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Booking;
import com.entity.Buy;
import com.service.BookingService;
import com.service.BuyService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/buy", produces = "text/plain;charset=utf-8")
public class BuyController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private BuyService buyService;
	@Autowired
	private BookingService bookingService;

	// 准备添加数据
	@RequestMapping("createBuy.action")
	public String createBuy() {
		this.getRequest().setAttribute("bno", "B" + VeDate.getStringDatex());
		return "admin/addbuy";
	}

	// 添加数据
	@RequestMapping("addBuy.action")
	public String addBuy(Buy buy) {
		double total = Double.parseDouble(buy.getNum()) * Double.parseDouble(buy.getPrice());
		buy.setTotal("" + VeDate.getDouble(total));
		buy.setAddtime(VeDate.getStringDateShort());
		this.buyService.insertBuy(buy);
		Booking booking = new Booking();
		booking.setAddtime(VeDate.getStringDateShort());
		booking.setBno(buy.getBno());
		booking.setCate("支出");
		booking.setReason("采购支出");
		booking.setTotal("" + VeDate.getDouble(total));
		this.bookingService.insertBooking(booking);
		return "redirect:/buy/createBuy.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteBuy.action")
	public String deleteBuy(String id) {
		this.buyService.deleteBuy(id);
		return "redirect:/buy/getAllBuy.action";
	}

	// 批量删除数据
	@RequestMapping("deleteBuyByIds.action")
	public String deleteBuyByIds() {
		String[] ids = this.getRequest().getParameterValues("buyid");
		if (ids != null) {
			for (String buyid : ids) {
				this.buyService.deleteBuy(buyid);
			}
		}
		return "redirect:/buy/getAllBuy.action";
	}

	// 更新数据
	@RequestMapping("updateBuy.action")
	public String updateBuy(Buy buy) {
		this.buyService.updateBuy(buy);
		return "redirect:/buy/getAllBuy.action";
	}

	// 显示全部数据
	@RequestMapping("getAllBuy.action")
	public String getAllBuy(String number) {
		List<Buy> buyList = this.buyService.getAllBuy();
		PageHelper.getUserPage(buyList, "buy", "getAllBuy", 10, number, this.getRequest());
		return "admin/listbuy";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryBuyByCond.action")
	public String queryBuyByCond(String cond, String name, String number) {
		Buy buy = new Buy();
		if (cond != null) {
			if ("bno".equals(cond)) {
				buy.setBno(name);
			}
			if ("goodsname".equals(cond)) {
				buy.setGoodsname(name);
			}
			if ("price".equals(cond)) {
				buy.setPrice(name);
			}
			if ("num".equals(cond)) {
				buy.setNum(name);
			}
			if ("total".equals(cond)) {
				buy.setTotal(name);
			}
			if ("addtime".equals(cond)) {
				buy.setAddtime(name);
			}
			if ("manager".equals(cond)) {
				buy.setManager(name);
			}
			if ("memo".equals(cond)) {
				buy.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.buyService.getBuyByLike(buy), "buy", nameList, valueList, 10, number, this.getRequest(),
				"query");
		name = null;
		cond = null;
		return "admin/querybuy";
	}

	// 按主键查询数据
	@RequestMapping("getBuyById.action")
	public String getBuyById(String id) {
		Buy buy = this.buyService.getBuyById(id);
		this.getRequest().setAttribute("buy", buy);
		return "admin/editbuy";
	}

}
