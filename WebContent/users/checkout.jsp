<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<title>${title }</title>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="<%=basePath%>">首页</a>
			<code> &gt; </code>
			确认订单
		</div>
	</div>
	<div class="blank"></div>
	<div class="block table">
		<h6>
			<span>食品列表</span>
		</h6>
		<table width="99%" align="center" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
			<tr>
				<th bgcolor="#ffffff">食品名称</th>
				<th bgcolor="#ffffff">价格</th>
				<th bgcolor="#ffffff">数量</th>
			</tr>
			<c:forEach items="${cartList}" var="cart">
				<tr>
					<td bgcolor="#ffffff" align="center" style="width: 300px;"><img style="width: 80px; height: 80px;"
						src="${cart.image }" border="0" title="${cart.foodsname }" /> <br /> ${cart.foodsname }</td>
					<td align="center" bgcolor="#ffffff">￥${cart.price }元</td>
					<td align="center" bgcolor="#ffffff">${cart.num }</td>
				</tr>
			</c:forEach>
		</table>
		<form action="index/checkout.action" method="post" name="theForm" id="theForm" onsubmit="return checkConsignee(this)">
			<div class="flowBox">
				<h6>
					<span>完善订单</span>
				</h6>
				<table width="59%" align="center" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
					<tr>
						<td bgcolor="#ffffff">订单号:</td>
						<td bgcolor="#ffffff" colspan="2">${ordercode }</td>
					</tr>
					<tr>
						<td bgcolor="#ffffff">总计:</td>
						<td bgcolor="#ffffff" colspan="2">${total }元</td>
					</tr>
					<tr>
						<td bgcolor="#ffffff">餐桌:</td>
						<td bgcolor="#ffffff" colspan="2"><select name="tabxid" class="inputBg" id="tabxid" style="width: 160px;"><option
									value="">---请选择餐桌--</option>
								<c:forEach items="${tabxList}" var="tabx">
									<option value="${tabx.tabxid}">${tabx.tabxname }(${tabx.cate })</option>
								</c:forEach></select></td>
					</tr>
					<tr>
						<td bgcolor="#ffffff">预定日期:</td>
						<td bgcolor="#ffffff" colspan="2"><input name="orderdate" type="text" class="inputBg" id="orderdate"
							onclick="WdatePicker()" readonly="readonly" style="width: 160px;" /></td>
					</tr>
					<tr>
						<td bgcolor="#ffffff">时间段:</td>
						<td bgcolor="#ffffff" colspan="2">
							<input name="sectionx" type="radio" id="sectionx" value="11:00-13:00"/>11:00-13:00
							&nbsp;&nbsp;&nbsp;
							<input name="sectionx" type="radio" id="sectionx" value="17:00-20:00" checked/>17:00-20:00
						</td>
					</tr>
					<tr>
						<td colspan="4" align="center" bgcolor="#ffffff"><input type="submit" class="bnt_blue_2" value="确定" /></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
