<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<title>${title }</title>
<link href="themes/ecmoban_dangdang/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="themes/ecmoban_dangdang/js/index.js" charset="utf-8"></script>
</head>

<body class="index_page" style="min-width: 1200px;">
	<jsp:include page="header.jsp"></jsp:include>

	<div class="block clearfix">
		<div class="f_l" style="width: 1200px;">

			<div class="container" id="idTransformView">
				<ul class="slider" id="idSlider">
					<li><img src="pic/001.jpg" /></li>
					<li><img src="pic/002.jpg" /></li>
					<li><img src="pic/003.jpg" /></li>
					<li><img src="pic/004.jpg" /></li>
				</ul>
				<ul class="num" id="idNum">
					<li></li>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</div>


		</div>
		<div class="blank"></div>
		<div class="blank"></div>
		<div class="goodsBox_1">
			<div class="xm-box">
				<h4 class="title">
					<span>客房信息</span> <a class="more" href="index/rooms.action">更多</a>
				</h4>
				<div id="show_new_area" class="clearfix">
					<c:forEach items="${roomsList}" var="rooms">
						<div class="pic" style='margin-left: 0px;'>
							<a href="index/roomsdetail.action?id=${rooms.roomsid }"><img src="${rooms.image }" alt="${rooms.roomsno }" class="img"
								style="width: 220px; height: 240px" /></a>
							<p class="name">
								<a href="index/roomsdetail.action?id=${rooms.roomsid }" title="${rooms.roomsno }">${rooms.roomsno }</a>
							</p>
							<p class="price">
								价格：<font class="f1"> ￥${rooms.price }元 </font>
							</p>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="blank"></div>
			<div class="xm-box">
				<h4 class="title">
					<span>餐桌信息</span> <a class="more" href="index/tabx.action">更多</a>
				</h4>
				<div id="show_new_area" class="clearfix">
					<c:forEach items="${tabxList}" var="tabx">
						<div class="pic" style='margin-left: 0px;'>
							<a href="index/tabxdetail.action?id=${tabx.tabxid }"><img src="${tabx.image }" alt="${tabx.tabxname }" class="img"
								style="width: 220px; height: 240px" /></a>
							<p class="name">
								<a href="index/tabxdetail.action?id=${tabx.tabxid }" title="${tabx.tabxname }">${tabx.tabxname }</a>
							</p>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="blank"></div>
			<c:forEach items="${frontList}" var="cate" varStatus="status">
				<div class="xm-box">
					<h4 class="title">
						<span>${cate.catename}</span> <a class="more" href="index/cate.action?id=${cate.cateid }">更多</a>
					</h4>
					<div id="show_new_area" class="clearfix">
						<c:forEach items="${cate.foodsList}" var="foods">
							<div class="pic" style='margin-left: 0px;'>
								<a href="index/detail.action?id=${foods.foodsid }"><img src="${foods.image }" alt="${foods.foodsname }" class="img"
									style="width: 220px; height: 240px" /></a>
								<p class="name">
									<a href="index/detail.action?id=${foods.foodsid }" title="${foods.foodsname }">${foods.foodsname }</a>
								</p>
								<p class="price">
									价格：<font class="f1"> ￥${foods.price }元 </font>
								</p>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="blank"></div>
			</c:forEach>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
