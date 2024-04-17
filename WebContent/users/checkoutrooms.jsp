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
			当前位置: <a href="index/index.action">首页</a>
			<code> &gt; </code>
			预约流程
		</div>
	</div>
	<div class="blank"></div>
	<div class="block table">
		<form action="index/addOrders.action" method="post" name="theForm" id="theForm">
			<div class="flowBox">
				<h6>
					<span>房间预约</span>
				</h6>
				<table width="60%" align="center" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
					<tr>
						<td bgcolor="#ffffff">预约单号:</td>
						<td bgcolor="#ffffff" colspan="2">${ordercode }<input name="ordercode" type="hidden" class="inputBg"
							id="ordercode" value="${ordercode }" /></td>
					</tr>
					<tr>
						<td bgcolor="#ffffff">房间:</td>
						<td bgcolor="#ffffff" colspan="2">${rooms.roomsno }<input name="roomsid" type="hidden" class="inputBg"
							id="roomsid" value="${rooms.roomsid }" /></td>
					</tr>
					<tr>
						<td bgcolor="#ffffff">开始日期:</td>
						<td bgcolor="#ffffff" colspan="2"><input name="thestart" type="text" class="inputBg" id="thestart"
							onclick="WdatePicker()" readonly="readonly" placeholder="请输入开始日期" /> (必填)</td>
					</tr>
					<tr>
						<td bgcolor="#ffffff">结束日期:</td>
						<td bgcolor="#ffffff" colspan="2"><input name="theend" type="text" class="inputBg" id="theend"
							onclick="WdatePicker()" readonly="readonly" placeholder="请输入结束日期" /> (必填)</td>
					</tr>
					<tr>
						<td bgcolor="#ffffff">备注:</td>
						<td bgcolor="#ffffff" colspan="2"><input name="memo" type="text" class="inputBg" id="memo" /></td>
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
