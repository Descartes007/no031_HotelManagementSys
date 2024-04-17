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
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body>
	<article class="page-container">
		<form class="form form-horizontal" id="form-article-add" action="orders/changeTabx.action" name="myform" method="post">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">订单号</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="ordercode" class="input-text" id="ordercode" value="${orders.ordercode }" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">餐桌</label>
				<div class="formControls col-xs-8 col-sm-9">
					<span class="select-box"><select name="tabxid" class="select" id="tabxid"><c:forEach items="${tabxList}" var="tabx">
								<option value="${tabx.tabxid}" ${tabx.tabxid == orders.tabxid?"selected":"" }>${tabx.tabxname }</option>
							</c:forEach></select></span>
				</div>
			</div>

			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
					<input type="hidden" id="basepath" value="<%=basePath%>" /> <input type="hidden" id="ordersid" name="ordersid"
						value="${orders.ordersid }">
					<button id="sub" class="btn btn-secondary radius" type="submit">
						<i class="Hui-iconfont">&#xe632;</i>提交保存
					</button>
					<button id="res" class="btn btn-default radius" type="reset">关闭</button>
				</div>
			</div>
		</form>
	</article>
	<script type="text/javascript">
		$(function() {
			$("#res").click(function() {
				var index = parent.layer.getFrameIndex(window.name);
				parent.location.reload();
				parent.layer.close(index);
			});
		});
	</script>
</body>
</html>

