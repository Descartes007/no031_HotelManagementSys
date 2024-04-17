<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	String role = (String) session.getAttribute("role");
	if ("管理员".equals(role)) {
%>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">

		<dl id="menu-admin">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>管理员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="admin/createAdmin.action" data-title="新增管理员" href="javascript:void(0)">新增管理员信息</a></li>
					<li><a data-href="admin/getAllAdmin.action" data-title="管理员列表" href="javascript:void(0)">管理员信息列表</a></li>
					<li><a data-href="admin/queryAdminByCond.action" data-title="管理员查询" href="javascript:void(0)">管理员信息查询</a></li>
					<li><a data-href="admin/prePwd.action" data-title="修改密码" href="javascript:void(0)">修改密码</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu-member">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>用户信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="users/getAllUsers.action" data-title="用户列表" href="javascript:void(0)">用户信息列表</a></li>
					<li><a data-href="users/queryUsersByCond.action" data-title="用户查询" href="javascript:void(0)">用户信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>员工信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="employ/createEmploy.action" data-title="新增员工" href="javascript:void(0)">新增员工信息</a></li>
					<li><a data-href="employ/getAllEmploy.action" data-title="员工列表" href="javascript:void(0)">员工信息列表</a></li>
					<li><a data-href="employ/queryEmployByCond.action" data-title="员工查询" href="javascript:void(0)">员工信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>新闻公告管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="article/createArticle.action" data-title="新增新闻公告" href="javascript:void(0)">新增新闻公告</a></li>
					<li><a data-href="article/getAllArticle.action" data-title="新闻公告列表" href="javascript:void(0)">新闻公告列表</a></li>
					<li><a data-href="article/queryArticleByCond.action" data-title="新闻公告查询" href="javascript:void(0)">新闻公告查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>餐桌信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="tabx/createTabx.action" data-title="新增餐桌" href="javascript:void(0)">新增餐桌信息</a></li>
					<li><a data-href="tabx/getAllTabx.action" data-title="餐桌列表" href="javascript:void(0)">餐桌信息列表</a></li>
					<li><a data-href="tabx/queryTabxByCond.action" data-title="餐桌查询" href="javascript:void(0)">餐桌信息查询</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>客房信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="rooms/createRooms.action" data-title="新增客房" href="javascript:void(0)">新增客房信息</a></li>
					<li><a data-href="rooms/getAllRooms.action" data-title="客房列表" href="javascript:void(0)">客房信息列表</a></li>
					<li><a data-href="rooms/queryRoomsByCond.action" data-title="客房查询" href="javascript:void(0)">客房信息查询</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>客房订单管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="roomorders/getAllRoomorders.action" data-title="客房订单列表" href="javascript:void(0)">客房订单列表</a></li>
					<li><a data-href="roomorders/queryRoomordersByCond.action" data-title="客房订单查询" href="javascript:void(0)">客房订单查询</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>食品类型管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="cate/createCate.action" data-title="新增食品类型" href="javascript:void(0)">新增食品类型信息</a></li>
					<li><a data-href="cate/getAllCate.action" data-title="食品类型列表" href="javascript:void(0)">食品类型信息列表</a></li>
					<li><a data-href="cate/queryCateByCond.action" data-title="食品类型查询" href="javascript:void(0)">食品类型信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>食品信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="foods/createFoods.action" data-title="新增食品" href="javascript:void(0)">新增食品信息</a></li>
					<li><a data-href="foods/getAllFoods.action" data-title="食品列表" href="javascript:void(0)">食品信息列表</a></li>
					<li><a data-href="foods/queryFoodsByCond.action" data-title="食品查询" href="javascript:void(0)">食品信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>食品订单管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="orders/getAllOrders.action" data-title="订单列表" href="javascript:void(0)">食品订单列表</a></li>
					<li><a data-href="orders/queryOrdersByCond.action" data-title="订单查询" href="javascript:void(0)">食品订单查询</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>用餐评价管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="topic/getAllTopic.action" data-title="用餐评价列表" href="javascript:void(0)">用餐评价信息列表</a></li>
					<li><a data-href="topic/queryTopicByCond.action" data-title="用餐评价查询" href="javascript:void(0)">用餐评价信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>消费记录管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="charge/getAllCharge.action" data-title="消费记录列表" href="javascript:void(0)">消费记录信息列表</a></li>
					<li><a data-href="charge/queryChargeByCond.action" data-title="消费记录查询" href="javascript:void(0)">消费记录信息查询</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>经营收支管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="booking/getAllBooking.action" data-title="经营收支列表" href="javascript:void(0)">经营收支信息列表</a></li>
					<li><a data-href="booking/queryBookingByCond.action" data-title="经营收支查询" href="javascript:void(0)">经营收支信息查询</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>意见反馈管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="complains/getAllComplains.action" data-title="意见反馈列表" href="javascript:void(0)">意见反馈信息列表</a></li>
					<li><a data-href="complains/queryComplainsByCond.action" data-title="意见反馈查询" href="javascript:void(0)">意见反馈信息查询</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>用户需求管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="needs/getAllNeeds.action" data-title="用户需求列表" href="javascript:void(0)">用户需求信息列表</a></li>
					<li><a data-href="needs/queryNeedsByCond.action" data-title="用户需求查询" href="javascript:void(0)">用户需求信息查询</a></li>
				</ul>
			</dd>
		</dl>
		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>酒店采购管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="buy/createBuy.action" data-title="新增酒店采购" href="javascript:void(0)">新增酒店采购信息</a></li>
					<li><a data-href="buy/getAllBuy.action" data-title="酒店采购列表" href="javascript:void(0)">酒店采购信息列表</a></li>
					<li><a data-href="buy/queryBuyByCond.action" data-title="酒店采购查询" href="javascript:void(0)">酒店采购信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>数据统计信息<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="admin/chartcate.jsp" data-title="收支统计" href="javascript:void(0)">收支统计</a></li>
					<li><a data-href="admin/chartreason.jsp" data-title="收入来源统计" href="javascript:void(0)">收入来源统计</a></li>
					<li><a data-href="admin/chartpie.jsp" data-title="用户评价统计" href="javascript:void(0)">用户评价统计</a></li>
				</ul>
			</dd>
		</dl>

	</div>
</aside>
<%
	} else {
%>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>个人信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="employ/userinfo.action" data-title="个人信息" href="javascript:void(0)">个人信息</a></li>
					<li><a data-href="employ/prePwd.action" data-title="修改密码" href="javascript:void(0)">修改密码</a></li>
				</ul>
			</dd>
		</dl>


		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>餐桌信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="tabx/queryTabxByCond.action" data-title="餐桌查询" href="javascript:void(0)">餐桌信息查询</a></li>
				</ul>
			</dd>
		</dl>


		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>食品信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="foods/queryFoodsByCond.action" data-title="食品查询" href="javascript:void(0)">食品信息查询</a></li>
				</ul>
			</dd>
		</dl>

		<dl id="menu">
			<dt>
				<i class="Hui-iconfont">&#xe62d;</i>订单信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a data-href="orders/getMyOrders.action" data-title="我的服务订单" href="javascript:void(0)">我的服务订单</a></li>
				</ul>
			</dd>
		</dl>



	</div>
</aside>
<%
	}
%>

