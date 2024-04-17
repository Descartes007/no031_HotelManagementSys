<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%><!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>欢迎使用网站后台管理系统</title>
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
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>客房管理 <span class="c-gray en">&gt;</span> 客房查询 <a
			class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="javascript:location.replace(location.href);"
			title="刷新"> <i class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th scope="col" colspan="10">客房查询</th>
				</tr>
				<tr class="text-c">
					<th class="center">房间号</th>
					<th class="center">客房类型</th>
					<th class="center">客房价格</th>
					<th class="center">客房面积</th>
					<th class="center">客房朝向</th>
					<th class="center">客房状态</th>
					<th class="center">点击数</th>
				</tr>
			</thead>
			<c:forEach items="${roomsList}" var="rooms">
				<tr class="text-c">
					<td class="center">${rooms.roomsno}</td>
					<td class="center">${rooms.cate}</td>
					<td class="center">${rooms.price}</td>
					<td class="center">${rooms.mianji}</td>
					<td class="center">${rooms.chaoxiang}</td>
					<td class="center">${rooms.status}</td>
					<td class="center">${rooms.hits}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="cl pd-5 mt-20"></div>
		<div class="text-c">
			<form action="rooms/queryRoomsByCond.action" name="myform" method="post">
				查询条件： <span class="select-box" style="width: 200px;"><select name="cond" class="select">
						<option value="roomsno">按房间号查询</option>
						<option value="cate">按客房类型查询</option>
						<option value="price">按客房价格查询</option>
						<option value="mianji">按客房面积查询</option>
						<option value="chaoxiang">按客房朝向查询</option>
						<option value="status">按客房状态查询</option>
						<option value="hits">按点击数查询</option>
				</select></span>&nbsp;&nbsp;关键字<input type="text" name="name" required style="width: 200px" class="input-text" />
				<button type="submit" class="btn btn-success radius">
					<i class="Hui-iconfont">&#xe665;</i> 查询
				</button>
			</form>
		</div>
	</div>
</body>
</html>

