<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>" />
<title>${title }</title>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="block box">
		<div class="blank"></div>
		<div id="ur_here">
			当前位置: <a href="<%=basePath%>">首页</a>
			<code> &gt; </code>
			客户需求
		</div>
	</div>
	<div class="blank"></div>

	<div class="blank"></div>
	<div class="block clearfix">

		<div class="AreaL">
			<div class="box">
				<div class="box_1">
					<div class="userCenterBox">
						<jsp:include page="usermenu.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>


		<div class="AreaR">
			<div class="box">
				<div class="box_1">
					<div class="userCenterBox boxCenterList clearfix" style="_height: 1%;">

						<h5>
							<span>客户需求</span>
						</h5>
						<div class="blank"></div>
						<form action="index/addNeeds.action" name="myform" method="post">
							<table width="100%" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
								<tr>
									<td width="20%" align="right" bgcolor="#FFFFFF">入住单：</td>
									<td width="80%" align="left" bgcolor="#FFFFFF"><select name="roomordersid" class="select" id="roomordersid"
										style="width: 210px; height: 27px;"><option value="">---请选择入住单--</option>
											<c:forEach items="${ordersList}" var="roomorders">
												<option value="${roomorders.roomordersid}">${roomorders.ordercode }</option>
											</c:forEach></select></td>
								</tr>
								<tr>
									<td align="right" bgcolor="#FFFFFF">物品：</td>
									<td align="left" bgcolor="#FFFFFF"><input name="goodsname" type="text" size="25" class="inputBg" id="goodsname"
										placeholder="请输入物品" /></td>
								</tr>
								<tr>
									<td colspan="2" align="center" bgcolor="#FFFFFF"><input type="submit" class="bnt_blue_1" style="border: none;" value="确认提交" /></td>
								</tr>
							</table>
						</form>

					</div>
				</div>
			</div>
		</div>

	</div>
	<div class="blank"></div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
