package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Orders;
import com.service.OrdersService;
import com.entity.Users;
import com.entity.Employ;
import com.entity.Tabx;
import com.service.UsersService;
import com.service.EmployService;
import com.service.TabxService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/orders", produces = "text/plain;charset=utf-8")
public class OrdersController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private EmployService employService;
	@Autowired
	private TabxService tabxService;

	@RequestMapping("createTabx.action")
	public String createTabx(String id) {
		Orders orders = this.ordersService.getOrdersById(id);
		List<Tabx> tabxList = this.tabxService.getAllTabx();
		this.getRequest().setAttribute("orders", orders);
		this.getRequest().setAttribute("tabxList", tabxList);
		return "admin/ordersTabx";
	}

	@RequestMapping("changeTabx.action")
	public String changeTabx() {
		String ordersid = this.getRequest().getParameter("ordersid");
		String tabxid = this.getRequest().getParameter("tabxid");
		Orders orders = this.ordersService.getOrdersById(ordersid);
		orders.setTabxid(tabxid);
		this.ordersService.updateOrders(orders);
		List<Tabx> tabxList = this.tabxService.getAllTabx();
		this.getRequest().setAttribute("orders", orders);
		this.getRequest().setAttribute("tabxList", tabxList);
		return "redirect:/orders/createTabx.action?id=" + ordersid;
	}

	// 准备添加数据
	@RequestMapping("createOrders.action")
	public String createOrders() {
		List<Users> usersList = this.usersService.getAllUsers();
		this.getRequest().setAttribute("usersList", usersList);
		List<Employ> employList = this.employService.getAllEmploy();
		this.getRequest().setAttribute("employList", employList);
		List<Tabx> tabxList = this.tabxService.getAllTabx();
		this.getRequest().setAttribute("tabxList", tabxList);
		return "admin/addorders";
	}

	// 添加数据
	@RequestMapping("addOrders.action")
	public String addOrders(Orders orders) {
		orders.setTotal("0");
		orders.setAddtime(VeDate.getStringDateShort());
		orders.setStatus("");
		this.ordersService.insertOrders(orders);
		return "redirect:/orders/createOrders.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteOrders.action")
	public String deleteOrders(String id) {
		this.ordersService.deleteOrders(id);
		return "redirect:/orders/getAllOrders.action";
	}

	// 批量删除数据
	@RequestMapping("deleteOrdersByIds.action")
	public String deleteOrdersByIds() {
		String[] ids = this.getRequest().getParameterValues("ordersid");
		if (ids != null) {
			for (String ordersid : ids) {
				this.ordersService.deleteOrders(ordersid);
			}
		}
		return "redirect:/orders/getAllOrders.action";
	}

	// 更新数据
	@RequestMapping("updateOrders.action")
	public String updateOrders(Orders orders) {
		this.ordersService.updateOrders(orders);
		return "redirect:/orders/getAllOrders.action";
	}

	// 更新状态
	@RequestMapping("status.action")
	public String status(String id) {
		String status = "已确认";
		Orders orders = this.ordersService.getOrdersById(id);
		orders.setStatus(status);
		String employid = this.getRequest().getParameter("employid");
		orders.setEmployid(employid);
		this.ordersService.updateOrders(orders);
		return "redirect:/orders/getAllOrders.action";
	}

	@RequestMapping("open.action")
	public String open(String id) {
		String status = "开台";
		Orders orders = this.ordersService.getOrdersById(id);
		orders.setStatus(status);
		this.ordersService.updateOrders(orders);
		return "redirect:/orders/getMyOrders.action";
	}

	@RequestMapping("over.action")
	public String over(String id) {
		String status = "用餐完成";
		Orders orders = this.ordersService.getOrdersById(id);
		orders.setStatus(status);
		this.ordersService.updateOrders(orders);
		return "redirect:/orders/getMyOrders.action";
	}

	// 显示全部数据
	@RequestMapping("getAllOrders.action")
	public String getAllOrders(String number) {
		List<Orders> ordersList = this.ordersService.getAllOrders();
		PageHelper.getPage(ordersList, "orders", null, null, 10, number, this.getRequest(), null);
		return "admin/listorders";
	}

	@RequestMapping("getMyOrders.action")
	public String getMyOrders(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Orders orders = new Orders();
		orders.setEmployid(adminid);
		List<Orders> ordersList = this.ordersService.getOrdersByCond(orders);
		PageHelper.getUserPage(ordersList, "orders", "getMyOrders", 10, number, this.getRequest());
		return "admin/xlistorders";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryOrdersByCond.action")
	public String queryOrdersByCond(String cond, String name, String number) {
		Orders orders = new Orders();
		if (cond != null) {
			if ("ordercode".equals(cond)) {
				orders.setOrdercode(name);
			}
			if ("usersid".equals(cond)) {
				orders.setUsersid(name);
			}
			if ("employid".equals(cond)) {
				orders.setEmployid(name);
			}
			if ("total".equals(cond)) {
				orders.setTotal(name);
			}
			if ("addtime".equals(cond)) {
				orders.setAddtime(name);
			}
			if ("status".equals(cond)) {
				orders.setStatus(name);
			}
			if ("tabxid".equals(cond)) {
				orders.setTabxid(name);
			}
			if ("orderdate".equals(cond)) {
				orders.setOrderdate(name);
			}
			if ("sectionx".equals(cond)) {
				orders.setSectionx(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.ordersService.getOrdersByLike(orders), "orders", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryorders";
	}

	// 按主键查询数据
	@RequestMapping("getOrdersById.action")
	public String getOrdersById(String id) {
		Orders orders = this.ordersService.getOrdersById(id);
		this.getRequest().setAttribute("orders", orders);
		Employ employ = new Employ();
		employ.setStatus("在职");
		List<Employ> employList = this.employService.getEmployByCond(employ);
		this.getRequest().setAttribute("employList", employList);
		return "admin/editorders";
	}

}
