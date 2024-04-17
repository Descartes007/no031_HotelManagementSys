package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Article;
import com.entity.Booking;
import com.entity.Cart;
import com.entity.Cate;
import com.entity.Charge;
import com.entity.Complains;
import com.entity.Details;
import com.entity.Foods;
import com.entity.Hist;
import com.entity.Needs;
import com.entity.Orders;
import com.entity.Roomorders;
import com.entity.Rooms;
import com.entity.Tabx;
import com.entity.Topic;
import com.entity.Users;
import com.service.ArticleService;
import com.service.BookingService;
import com.service.CartService;
import com.service.CateService;
import com.service.ChargeService;
import com.service.ComplainsService;
import com.service.DetailsService;
import com.service.FoodsService;
import com.service.HistService;
import com.service.NeedsService;
import com.service.OrdersService;
import com.service.RecommendService;
import com.service.RoomordersService;
import com.service.RoomsService;
import com.service.TabxService;
import com.service.TopicService;
import com.service.UsersService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/index")
public class IndexController extends BaseController {

	@Autowired
	private UsersService usersService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private TabxService tabxService;
	@Autowired
	private CateService cateService;
	@Autowired
	private FoodsService foodsService;
	@Autowired
	private CartService cartService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private DetailsService detailsService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private ChargeService chargeService;
	@Autowired
	private ComplainsService complainsService;
	@Autowired
	private RoomsService roomsService;
	@Autowired
	private RoomordersService roomordersService;
	@Autowired
	private HistService histService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private NeedsService needsService;
	@Autowired
	private RecommendService recommendService;

	// 协同过滤算法调用
	private void recommend() {
		// 推荐食品的算法 1 用户未登录 直接调用foodsService的getGoodsByHot方法
		// 2 用户登录 但是没有浏览食品 则调用1
		// 3 用户登录 且有浏览的食品 调用recommendService 通过协同过滤算法 自动推荐食品
		if (this.getSession().getAttribute("userid") == null) {
			List<Foods> hotList = this.foodsService.getFoodsByHot();
			this.getRequest().setAttribute("hotList", hotList);
		} else {
			String userid = (String) this.getSession().getAttribute("userid");
			Hist hist = new Hist();
			hist.setUsersid(userid);
			List<Hist> histList = this.histService.getHistByCond(hist);
			if (histList.size() == 0) {
				List<Foods> hotList = this.foodsService.getFoodsByHot();
				this.getRequest().setAttribute("hotList", hotList);
			} else {
				List<Foods> hotList = this.recommendService.getRecommend(userid);
				this.getRequest().setAttribute("hotList", hotList);
				System.out.println(hotList.size());
			}
		}
	}

	// 公共方法 提供公共查询数据
	private void front() {
		this.getRequest().setAttribute("title", "酒店管理系统");
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		List<Foods> hotList = this.foodsService.getFoodsByHot();
		this.getRequest().setAttribute("hotList", hotList);
	}

	// 首页显示
	@RequestMapping("index.action")
	public String index() {
		this.front();
		List<Cate> cateList = this.cateService.getCateFront();
		List<Cate> frontList = new ArrayList<Cate>();
		for (Cate cate : cateList) {
			List<Foods> foodsList = this.foodsService.getFoodsByCate(cate.getCateid());
			cate.setFoodsList(foodsList);
			frontList.add(cate);
		}
		this.getRequest().setAttribute("frontList", frontList);
		List<Tabx> tabxList = this.tabxService.getFrontTabx();
		this.getRequest().setAttribute("tabxList", tabxList);
		List<Rooms> roomsList = this.roomsService.getFrontRooms();
		this.getRequest().setAttribute("roomsList", roomsList);
		return "users/index";
	}

	// 公告
	@RequestMapping("article.action")
	public String article(String number) {
		this.front();
		this.recommend();
		List<Article> tempList = this.articleService.getAllArticle();
		PageHelper.getIndexPage(tempList, "article", "article", null, 10, number, this.getRequest());
		return "users/article";
	}

	// 阅读公告
	@RequestMapping("read.action")
	public String read(String id) {
		this.front();
		Article article = this.articleService.getArticleById(id);
		article.setHits("" + (Integer.parseInt(article.getHits()) + 1));
		this.articleService.updateArticle(article);
		this.getRequest().setAttribute("article", article);
		return "users/read";
	}

	// 准备登录
	@RequestMapping("preLogin.action")
	public String prelogin() {
		this.front();
		return "users/login";
	}

	// 用户登录
	@RequestMapping("login.action")
	public String login() {
		this.front();
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		String RANDOMCODEKEY = (String) this.getSession().getAttribute("RANDOMVALIDATECODEKEY");
		String checkcode = this.getRequest().getParameter("checkcode").toUpperCase();
		if (!checkcode.equals(RANDOMCODEKEY)) {
			this.getSession().setAttribute("message", "验证码错误");
			return "redirect:/index/preLogin.action";
		}
		Users u = new Users();
		u.setUsername(username);
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			this.getSession().setAttribute("message", "用户名不存在");
			return "redirect:/index/preLogin.action";
		} else {
			Users users = usersList.get(0);
			if (password.equals(users.getPassword())) {
				this.getSession().setAttribute("userid", users.getUsersid());
				this.getSession().setAttribute("username", users.getUsername());
				this.getSession().setAttribute("users", users);
				return "redirect:/index/index.action";
			} else {
				this.getSession().setAttribute("message", "密码错误");
				return "redirect:/index/preLogin.action";
			}
		}
	}

	// 准备注册
	@RequestMapping("preReg.action")
	public String preReg() {
		this.front();
		return "users/register";
	}

	// 用户注册
	@RequestMapping("register.action")
	public String register(Users users) {
		this.front();
		Users u = new Users();
		u.setUsername(users.getUsername());
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			users.setRegdate(VeDate.getStringDateShort());
			this.usersService.insertUsers(users);
		} else {
			this.getSession().setAttribute("message", "用户名已存在");
			return "redirect:/index/preReg.action";
		}

		return "redirect:/index/preLogin.action";
	}

	// 退出登录
	@RequestMapping("exit.action")
	public String exit() {
		this.front();
		this.getSession().removeAttribute("userid");
		this.getSession().removeAttribute("username");
		this.getSession().removeAttribute("users");
		return "redirect:/index/index.action";
	}

	// 准备修改密码
	@RequestMapping("prePwd.action")
	public String prePwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/editpwd";
	}

	// 修改密码
	@RequestMapping("editpwd.action")
	public String editpwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		String password = this.getRequest().getParameter("password");
		String repassword = this.getRequest().getParameter("repassword");
		Users users = this.usersService.getUsersById(userid);
		if (password.equals(users.getPassword())) {
			users.setPassword(repassword);
			this.usersService.updateUsers(users);
		} else {
			this.getSession().setAttribute("message", "旧密码错误");
			return "redirect:/index/prePwd.action";
		}
		this.getSession().setAttribute("message", "修改成功");
		return "redirect:/index/prePwd.action";
	}

	@RequestMapping("usercenter.action")
	public String usercenter() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/usercenter";
	}

	@RequestMapping("userinfo.action")
	public String userinfo() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		this.getSession().setAttribute("users", this.usersService.getUsersById(userid));
		return "users/userinfo";
	}

	@RequestMapping("personal.action")
	public String personal(Users users) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.usersService.updateUsers(users);
		this.getSession().setAttribute("message", "修改成功");
		return "redirect:/index/userinfo.action";
	}

	// 添加食品到购物车
	@RequestMapping("addcart.action")
	public String addcart() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Cart cart = new Cart();
		cart.setAddtime(VeDate.getStringDateShort());
		cart.setFoodsid(getRequest().getParameter("foodsid"));
		cart.setNum(getRequest().getParameter("num"));
		cart.setPrice(getRequest().getParameter("price"));
		cart.setUsersid(userid);
		this.cartService.insertCart(cart);
		return "redirect:/index/cart.action";
	}

	// 查看购物车
	@RequestMapping("cart.action")
	public String cart() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Cart cart = new Cart();
		cart.setUsersid(userid);
		List<Cart> cartList = this.cartService.getCartByCond(cart);
		this.getRequest().setAttribute("cartList", cartList);
		return "users/cart";
	}

	// 删除购物车中的食品
	@RequestMapping("deletecart.action")
	public String deletecart(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.cartService.deleteCart(id);
		return "redirect:/index/cart.action";
	}

	// 准备结算
	@RequestMapping("preCheckout.action")
	public String preCheckout() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Cart cart = new Cart();
		cart.setUsersid(userid);
		List<Cart> cartList = this.cartService.getCartByCond(cart);
		if (cartList.size() == 0) {
			this.getRequest().setAttribute("message", "请选购食品");
			return "redirect:/index/cart.action";
		}
		double total = 0;
		for (Cart x : cartList) {
			total += Double.parseDouble(x.getPrice()) * Double.parseDouble(x.getNum());
		}
		List<Tabx> tabxList = this.tabxService.getAllTabx();
		String ordercode = "FD" + VeDate.getStringDatex();
		this.getRequest().setAttribute("tabxList", tabxList);
		this.getRequest().setAttribute("ordercode", ordercode);
		this.getRequest().setAttribute("cartList", cartList);
		this.getRequest().setAttribute("total", total);
		return "users/checkout";
	}

	// 结算
	@RequestMapping("checkout.action")
	public String checkout() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String tabxid = this.getRequest().getParameter("tabxid");
		String orderdate = this.getRequest().getParameter("orderdate");
		String sectionx = this.getRequest().getParameter("sectionx");
		String ordersid = "";
		Orders x = new Orders();
		x.setSectionx(sectionx);
		x.setOrderdate(orderdate);
		x.setTabxid(tabxid);
		List<Orders> list = this.ordersService.getOrdersByCond(x);
		if (list.size() != 0) {
			this.getSession().setAttribute("message", "此时段已被预定,请换个餐桌试试");
			return "redirect:/index/preCheckout.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Cart cart1 = new Cart();
		cart1.setUsersid(userid);
		List<Cart> cartList = this.cartService.getCartByCond(cart1);
		if (cartList.size() == 0) {
			this.getRequest().setAttribute("message", "请选购食品");
			return "redirect:/index/cart.action";
		} else {
			// 获取一个1000-9999的随机数 防止同时提交
			String ordercode = "FD" + VeDate.getStringDatex();
			double total = 0;
			Orders orders = new Orders();
			ordersid = orders.getOrdersid();
			for (Cart cart : cartList) {
				Details details = new Details();
				details.setDetailsid(UUID.randomUUID().toString().replace("-", ""));
				details.setFoodsid(cart.getFoodsid());
				details.setNum(cart.getNum());
				details.setOrdersid(ordersid);
				details.setPrice(cart.getPrice());
				details.setMemo("点餐");
				this.detailsService.insertDetails(details);
				Foods foods = this.foodsService.getFoodsById(cart.getFoodsid());
				foods.setSellnum("" + (Integer.parseInt(foods.getSellnum()) + Integer.parseInt(cart.getNum())));
				this.foodsService.updateFoods(foods);
				total += Double.parseDouble(cart.getPrice()) * Double.parseDouble(cart.getNum());
				this.cartService.deleteCart(cart.getCartid());
			}
			orders.setAddtime(VeDate.getStringDateShort());
			orders.setOrdercode(ordercode);
			orders.setStatus("未付款");
			orders.setTotal("" + VeDate.getDouble(total));
			orders.setUsersid(userid);
			orders.setOrderdate(orderdate);
			orders.setSectionx(sectionx);
			orders.setTabxid(tabxid);
			this.ordersService.insertOrders(orders);

		}
		return "redirect:/index/prePay.action?id=" + ordersid;
	}

	// 查看订购
	@RequestMapping("showOrders.action")
	public String showOrders(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Orders orders = new Orders();
		orders.setUsersid(userid);
		List<Orders> tempList = this.ordersService.getOrdersByCond(orders);
		PageHelper.getIndexPage(tempList, "orders", "showOrders", null, 10, number, this.getRequest());
		return "users/orderlist";
	}

	// 准备付款
	@RequestMapping("prePay.action")
	public String prePay(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.getRequest().setAttribute("id", id);
		Orders orders = this.ordersService.getOrdersById(id);
		this.getRequest().setAttribute("orders", orders);
		return "users/pay";
	}

	// 付款
	@RequestMapping("pay.action")
	public String pay(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
		orders.setStatus("已付款");
		this.ordersService.updateOrders(orders);
		Charge charge = new Charge();
		charge.setAddtime(VeDate.getStringDateShort());
		charge.setCno(orders.getOrdercode());
		charge.setOrdersid(id);
		charge.setTotal(orders.getTotal());
		charge.setUsersid(orders.getUsersid());
		this.chargeService.insertCharge(charge);
		Booking booking = new Booking();
		booking.setAddtime(VeDate.getStringDateShort());
		booking.setBno(orders.getOrdercode());
		booking.setCate("收入");
		booking.setReason("餐饮收入");
		booking.setTotal(orders.getTotal());
		this.bookingService.insertBooking(booking);
		return "redirect:/index/showOrders.action";
	}

	// 确认收货
	@RequestMapping("over.action")
	public String over(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
		orders.setStatus("用餐完成");
		this.ordersService.updateOrders(orders);
		return "redirect:/index/showOrders.action";
	}

	// 取消订单
	@RequestMapping("cancel.action")
	public String cancel(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
		orders.setStatus("已取消");
		this.ordersService.updateOrders(orders);
		return "redirect:/index/showOrders.action";
	}

	// 订单明细
	@RequestMapping("orderdetail.action")
	public String orderdetail(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Details details = new Details();
		details.setOrdersid(id);
		List<Details> detailsList = this.detailsService.getDetailsByCond(details);
		this.getRequest().setAttribute("detailsList", detailsList);
		return "users/orderdetail";
	}

	// 按分类查询
	@RequestMapping("cate.action")
	public String cate(String id, String number) {
		this.front();
		this.recommend();
		Foods foods = new Foods();
		foods.setCateid(id);
		List<Foods> tempList = this.foodsService.getFoodsByCond(foods);
		PageHelper.getIndexPage(tempList, "foods", "cate", id, 12, number, this.getRequest());
		return "users/list";
	}

	// 推荐食品
	@RequestMapping("recommend.action")
	public String recommend(String number) {
		this.front();
		this.recommend();
		Foods foods = new Foods();
		foods.setRecommend("是");
		List<Foods> tempList = this.foodsService.getFoodsByCond(foods);
		PageHelper.getIndexPage(tempList, "foods", "recommend", null, 12, number, this.getRequest());
		return "users/list";
	}

	// 全部食品
	@RequestMapping("all.action")
	public String all(String number) {
		this.front();
		this.recommend();
		List<Foods> tempList = this.foodsService.getAllFoods();
		PageHelper.getIndexPage(tempList, "foods", "all", null, 12, number, this.getRequest());
		return "users/list";
	}

	// 查询食品
	@RequestMapping("query.action")
	public String query(String name) {
		this.front();
		this.recommend();
		Foods foods = new Foods();
		foods.setFoodsname(name);
		List<Foods> foodsList = this.foodsService.getFoodsByLike(foods);
		this.getRequest().setAttribute("foodsList", foodsList);
		return "users/list";
	}

	// 食品详情
	@RequestMapping("detail.action")
	public String detail(String id) {
		this.front();
		Foods foods = this.foodsService.getFoodsById(id);
		foods.setHits("" + (Integer.parseInt(foods.getHits()) + 1));
		this.foodsService.updateFoods(foods);
		this.getRequest().setAttribute("foods", foods);
		Topic topic = new Topic();
		topic.setFoodsid(id);
		List<Topic> topicList = this.topicService.getTopicByCond(topic);
		this.getRequest().setAttribute("topicList", topicList);
		this.getRequest().setAttribute("tnum", topicList.size());
		if (this.getSession().getAttribute("userid") != null) {
			String userid = (String) this.getSession().getAttribute("userid");
			Hist hist = new Hist();
			hist.setUsersid(userid);
			hist.setFoodsid(id);
			List<Hist> histList = this.histService.getHistByCond(hist);
			if (histList.size() == 0) {
				hist.setNum("1");
				this.histService.insertHist(hist);
			} else {
				Hist h = histList.get(0);
				h.setNum("" + (Integer.parseInt(h.getNum()) + 1));
				this.histService.updateHist(h);
			}
		}
		this.recommend();
		return "users/detail";
	}

	@RequestMapping("tabx.action")
	public String tabx(String number) {
		this.front();
		this.recommend();
		List<Tabx> tempList = this.tabxService.getAllTabx();
		PageHelper.getIndexPage(tempList, "tabx", "tabx", null, 12, number, this.getRequest());
		return "users/tabx";
	}

	@RequestMapping("tabxdetail.action")
	public String tabxdetail(String id) {
		this.front();
		this.recommend();
		Tabx tabx = this.tabxService.getTabxById(id);
		this.getRequest().setAttribute("tabx", tabx);
		return "users/tabxdetail";
	}

	@RequestMapping("preTopic.action")
	public String preTopic(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(id);
		this.getRequest().setAttribute("id", id);
		this.getRequest().setAttribute("orders", orders);
		Details items = new Details();
		items.setOrdersid(id);
		List<Details> itemsList = this.detailsService.getDetailsByCond(items);
		this.getRequest().setAttribute("itemsList", itemsList);
		return "users/addTopic";
	}

	@RequestMapping("addTopic.action")
	public String addTopic(Topic topic) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String ordersid = this.getRequest().getParameter("id");
		Orders orders = this.ordersService.getOrdersById(ordersid);
		orders.setStatus("已评价");
		this.ordersService.updateOrders(orders);
		String userid = (String) this.getSession().getAttribute("userid");
		Details items = new Details();
		items.setOrdersid(ordersid);
		List<Details> itemsList = this.detailsService.getDetailsByCond(items);
		for (int i = 0; i < itemsList.size(); i++) {
			Details x = itemsList.get(i);
			topic.setAddtime(VeDate.getStringDateShort());
			topic.setFoodsid(x.getFoodsid());
			topic.setNum(this.getRequest().getParameter("tnum_" + (i + 1)));
			topic.setContents(this.getRequest().getParameter("contents_" + (i + 1)));
			topic.setOrdersid(ordersid);
			topic.setUsersid(userid);
			topic.setTopicid(UUID.randomUUID().toString().replace("-", ""));
			this.topicService.insertTopic(topic);
		}
		return "redirect:/index/showOrders.action";
	}

	@RequestMapping("preComplains.action")
	public String preComplains() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/addComplains";
	}

	@RequestMapping("addComplains.action")
	public String addComplains(Complains complains) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		complains.setAddtime(VeDate.getStringDateShort());
		complains.setStatus("未回复");
		complains.setUsersid(userid);
		this.complainsService.insertComplains(complains);
		return "redirect:/index/preComplains.action";
	}

	@RequestMapping("myComplains.action")
	public String myComplains(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Complains complains = new Complains();
		complains.setUsersid(userid);
		List<Complains> complainsList = this.complainsService.getComplainsByCond(complains);
		PageHelper.getIndexPage(complainsList, "complains", "myComplains", null, 10, number, this.getRequest());
		return "users/myComplains";
	}

	@RequestMapping("myCharge.action")
	public String myCharge(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Charge charge = new Charge();
		charge.setUsersid(userid);
		List<Charge> chargeList = this.chargeService.getChargeByCond(charge);
		PageHelper.getIndexPage(chargeList, "charge", "myCharge", null, 10, number, this.getRequest());
		return "users/myCharge";
	}

	@RequestMapping("rooms.action")
	public String rooms(String number) {
		this.front();
		this.recommend();
		List<Rooms> tempList = this.roomsService.getAllRooms();
		PageHelper.getIndexPage(tempList, "rooms", "rooms", null, 12, number, this.getRequest());
		return "users/roomslist";
	}

	@RequestMapping("roomsdetail.action")
	public String roomsdetail(String id) {
		this.front();
		this.recommend();
		Rooms rooms = this.roomsService.getRoomsById(id);
		this.getRequest().setAttribute("rooms", rooms);
		rooms.setHits("" + (Integer.parseInt(rooms.getHits()) + 1));
		this.roomsService.updateRooms(rooms);
		return "users/roomsdetail";
	}

	@RequestMapping("preOrders.action")
	public String preOrders(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Rooms rooms = this.roomsService.getRoomsById(id);
		this.getRequest().setAttribute("rooms", rooms);
		this.getRequest().setAttribute("ordercode", "RD" + VeDate.getStringDatex());
		return "users/checkoutrooms";
	}

	@RequestMapping("addOrders.action")
	public String addOrders(Roomorders orders) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Roomorders x = new Roomorders();
		x.setRoomsid(orders.getRoomsid());
		x.setThestart(orders.getThestart());
		x.setTheend(orders.getTheend());
		Rooms rooms = this.roomsService.getRoomsById(orders.getRoomsid());
		List<Roomorders> list = this.roomordersService.getRoomordersByCond(x);
		if (list.size() == 0) {
			long days = Math.abs(VeDate.getDays(orders.getTheend(), orders.getThestart())) + 1;
			double total = days * Double.parseDouble(rooms.getPrice());
			orders.setTotal("" + total);
			orders.setStatus("未付款");
			orders.setUsersid(userid);
			orders.setAddtime(VeDate.getStringDateShort());
			this.roomordersService.insertRoomorders(orders);
		} else {
			this.getSession().setAttribute("message", "此时间段客房被占用");
			return "redirect:/index/roomsdetail.action?id=" + orders.getRoomsid();
		}
		return "redirect:/index/roomorders.action";
	}

	@RequestMapping("roomorders.action")
	public String roomorders(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Roomorders orders = new Roomorders();
		orders.setUsersid(userid);
		List<Roomorders> ordersList = this.roomordersService.getRoomordersByCond(orders);
		PageHelper.getIndexPage(ordersList, "roomorders", "roomorders", null, 10, number, this.getRequest());
		return "users/roomorderslist";
	}

	// 准备付款
	@RequestMapping("prePay1.action")
	public String prePay1(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.getRequest().setAttribute("id", id);
		Roomorders orders = this.roomordersService.getRoomordersById(id);
		this.getRequest().setAttribute("orders", orders);
		return "users/pay1";
	}

	// 付款
	@RequestMapping("pay1.action")
	public String pay1(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Roomorders orders = this.roomordersService.getRoomordersById(id);
		orders.setStatus("已付款");
		this.roomordersService.updateRoomorders(orders);
		Charge charge = new Charge();
		charge.setAddtime(VeDate.getStringDateShort());
		charge.setCno(orders.getOrdercode());
		charge.setOrdersid("O20210330061044247");
		charge.setTotal(orders.getTotal());
		charge.setUsersid(orders.getUsersid());
		this.chargeService.insertCharge(charge);
		Booking booking = new Booking();
		booking.setAddtime(VeDate.getStringDateShort());
		booking.setBno(orders.getOrdercode());
		booking.setCate("收入");
		booking.setReason("客房收入");
		booking.setTotal(orders.getTotal());
		this.bookingService.insertBooking(booking);
		return "redirect:/index/roomorders.action";
	}

	@RequestMapping("preNeeds.action")
	public String preNeeds() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Roomorders orders = new Roomorders();
		orders.setUsersid(userid);
		orders.setStatus("已入住");
		List<Roomorders> ordersList = this.roomordersService.getRoomordersByCond(orders);
		this.getRequest().setAttribute("ordersList", ordersList);
		return "users/addNeeds";
	}

	@RequestMapping("addNeeds.action")
	public String addNeeds(Needs needs) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String roomordersid = this.getRequest().getParameter("roomordersid");
		Roomorders orders = this.roomordersService.getRoomordersById(roomordersid);
		String userid = (String) this.getSession().getAttribute("userid");
		needs.setAddtime(VeDate.getStringDateShort());
		needs.setStatus("未回复");
		needs.setUsersid(userid);
		needs.setRoomsid(orders.getRoomsid());
		this.needsService.insertNeeds(needs);
		return "redirect:/index/myNeeds.action";
	}

	@RequestMapping("myNeeds.action")
	public String myNeeds(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Needs needs = new Needs();
		needs.setUsersid(userid);
		List<Needs> needsList = this.needsService.getNeedsByCond(needs);
		PageHelper.getIndexPage(needsList, "needs", "myNeeds", null, 10, number, this.getRequest());
		return "users/myNeeds";
	}
}
