package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Charge;
import com.service.ChargeService;
import com.entity.Orders;
import com.entity.Users;
import com.service.OrdersService;
import com.service.UsersService;
import com.util.PageHelper;
import com.util.VeDate;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/charge" , produces = "text/plain;charset=utf-8")
public class ChargeController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private ChargeService chargeService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private UsersService usersService;

	// 准备添加数据
	@RequestMapping("createCharge.action")
	public String createCharge() {
		List<Orders> ordersList = this.ordersService.getAllOrders();
		this.getRequest().setAttribute("ordersList", ordersList);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/addcharge";
	}
	// 添加数据
	@RequestMapping("addCharge.action")
	public String addCharge(Charge charge) {
		charge.setAddtime(VeDate.getStringDateShort());
		this.chargeService.insertCharge(charge);
		return "redirect:/charge/createCharge.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteCharge.action")
	public String deleteCharge(String id) {
		this.chargeService.deleteCharge(id);
		return "redirect:/charge/getAllCharge.action";
	}

	// 批量删除数据
	@RequestMapping("deleteChargeByIds.action")
	public String deleteChargeByIds() {
		String[] ids = this.getRequest().getParameterValues("chargeid");
		if (ids != null) {
			for (String chargeid : ids) {
				this.chargeService.deleteCharge(chargeid);
			}
		}
		return "redirect:/charge/getAllCharge.action";
	}

	// 更新数据
	@RequestMapping("updateCharge.action")
	public String updateCharge(Charge charge) {
		this.chargeService.updateCharge(charge);
		return "redirect:/charge/getAllCharge.action";
	}

	// 显示全部数据
	@RequestMapping("getAllCharge.action")
	public String getAllCharge(String number) {
		List<Charge> chargeList = this.chargeService.getAllCharge();
		PageHelper.getPage(chargeList, "charge", null, null, 10, number, this.getRequest(), null);
		return "admin/listcharge";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryChargeByCond.action")
	public String queryChargeByCond(String cond, String name, String number) {
		Charge charge = new Charge();
		if(cond != null){
			if ("cno".equals(cond)) {
				charge.setCno(name);
			}
			if ("ordersid".equals(cond)) {
				charge.setOrdersid(name);
			}
			if ("usersid".equals(cond)) {
				charge.setUsersid(name);
			}
			if ("total".equals(cond)) {
				charge.setTotal(name);
			}
			if ("addtime".equals(cond)) {
				charge.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.chargeService.getChargeByLike(charge), "charge", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querycharge";
	}

	// 按主键查询数据
	@RequestMapping("getChargeById.action")
	public String getChargeById(String id) {
		Charge charge = this.chargeService.getChargeById(id);
		this.getRequest().setAttribute("charge", charge);
		List<Orders> ordersList = this.ordersService.getAllOrders();
		this.getRequest().setAttribute("ordersList", ordersList);
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		return "admin/editcharge";
	}


}
