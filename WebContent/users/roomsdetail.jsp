<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>${title }</title>
<script type="text/javascript" src="themes/ecmoban_dangdang/js/action.js"></script>
<script type="text/javascript" src="themes/ecmoban_dangdang/js/mzp-packed-me.js"></script>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="index.jsp">首页</a>
			<code> &gt; </code>
			${rooms.roomsno }
		</div>
	</div>
	<div class="blank"></div>
	<div class="block clearfix">
		<div class="AreaL">
			<div id="category_tree" class="category_tree">
				<div class="title">所有食品分类</div>
				<dl class="clearfix" style="background: #fafafa; width: 216px; padding: 0;">
					<div class="box1 cate" id="cate">
						<c:forEach items="${cateList}" var="cate">
							<h1>
								<a href="index/cate.action?id=${cate.cateid }" class="  f_l">${cate.catename }</a>
							</h1>
							<div style="clear: both"></div>
						</c:forEach>
					</div>
					<div style="clear: both"></div>
				</dl>
			</div>
			<div class="blank"></div>
			<div class="box" id='history_div'>
				<div class="box_1">
					<h3>
						<span>猜你喜欢</span>
					</h3>
					<div class="boxCenterList clearfix" id='history_list'>
						<c:forEach items="${hotList}" var="foods">
							<ul class="clearfix">
								<li class="goodsimg"><a href="index/detail.action?id=${foods.foodsid }" target="_blank"><img src="${foods.image }"
										alt="${foods.foodsname }" class="B_blue" /> </a></li>
								<li><a href="index/detail.action?id=${foods.foodsid }" target="_blank" title="${foods.foodsname }">${foods.foodsname }</a> <br />
									价格： <font class="f1">￥${foods.price}元</font> <br /></li>
							</ul>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="blank5"></div>
		</div>
		<div class="AreaR">
			<div id="goodsInfo" class="clearfix">
				<div class="imgInfo">
					<img src="${rooms.image }" alt="${rooms.roomsno }" width="360px;" height="360px" />
					<div class="blank5"></div>
					<div class="blank"></div>
				</div>
				<div class="textInfo">
					<form action="index/addcart.action" method="post" name="ECS_FORMBUY" id="ECS_FORMBUY">
						<h1 class="clearfix">${rooms.roomsno }</h1>
						<ul class="ul2 clearfix">
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>价格：</strong><font class="shop" id="ECS_SHOPPRICE">￥${rooms.price }元/天</font>
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>客房类型：</strong> ${rooms.cate }
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>点击数：</strong>${rooms.hits}
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>客房面积：</strong>${rooms.mianji}
								</dd>
							</li>
							<li class="clearfix" style="width: 100%">
								<dd>
									<strong>客房朝向：</strong>${rooms.chaoxiang}
								</dd>
							</li>
						</ul>
						<ul class="bnt_ul">
							<li class="padd"><a href="index/preOrders.action?id=${rooms.roomsid }"><img alt=""
									src="themes/ecmoban_dangdang/images/goumai.gif"></a></li>
						</ul>
					</form>
				</div>
			</div>
			<div class="blank"></div>
			<div class="box">
				<div style="padding: 0 0px;">
					<div id="com_b" class="history clearfix">
						<h2 class="h2bg">客房描述</h2>
					</div>
				</div>
				<div class="box_1">
					<div id="com_v" class="  " style="padding: 6px;"></div>
					<div id="com_h">
						<blockquote>${rooms.contents }</blockquote>
					</div>
				</div>
			</div>
			<div class="blank"></div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
