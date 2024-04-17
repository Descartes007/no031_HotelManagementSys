<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用后台管理系统</title>
<link rel="stylesheet" type="text/css" href="h-ui/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="h-ui/h-ui.admin/css/style.css" />
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="h-ui/h-ui.admin/js/H-ui.admin.js"></script>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>订单管理 <span class="c-gray en">&gt;</span>
		订单列表 <a class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"> <i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i
					class="Hui-iconfont">&#xe6e2;</i>批量删除</a> </span>
		</div>
		<form action="orders/deleteOrdersByIds.action" method="post" id="myform" name="myform">
			<table class="table table-border table-bordered table-bg">
				<thead>
					<tr>
						<th scope="col" colspan="11">订单列表</th>
					</tr>
					<tr class="text-c">
						<th width="25"><input type="checkbox" name="" value=""></th>
						<th>订单号</th>
						<th>用户</th>
						<th>服务员</th>
						<th>总计</th>
						<th>下单日期</th>
						<th>状态</th>
						<th>餐桌</th>
						<th>预定日期</th>
						<th>时间段</th>
						<th>操作</th>
					</tr>
				</thead>
				<c:forEach items="${ordersList}" var="orders">
					<tr class="text-c">
						<td><input type="checkbox" value="${orders.ordersid}" name="ordersid"></td>
						<td>${orders.ordercode}</td>
						<td>${orders.username}</td>
						<td>${orders.employname}</td>
						<td>${orders.total}</td>
						<td>${orders.addtime}</td>
						<td>${orders.status}</td>
						<td>${orders.tabxname}</td>
						<td>${orders.orderdate}</td>
						<td>${orders.sectionx}</td>
						<td><c:if test="${orders.status eq '已付款'}">
								<a href="orders/getOrdersById.action?id=${orders.ordersid}">确认订单</a>&nbsp;&nbsp;</c:if><a
							href="orders/deleteOrders.action?id=${orders.ordersid}"
							onclick="{if(confirm('确定要删除吗?')){return true;}return false;}"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="r">${html } </span>
		</div>
	</div>
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">
		/*批量删除*/
		function datadel() {
			if (confirm('确定要删除吗?')) {
				document.myform.submit();
			}
		}
	</script>
</body>
</html>

