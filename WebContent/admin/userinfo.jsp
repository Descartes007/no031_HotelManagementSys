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
<script type="text/javascript" src="js/employ.js" charset="utf-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>员工管理 <span class="c-gray en">&gt;</span> 编辑员工<a
			class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="employ/getEmployById.action?id=${employ.employid }"
			title="刷新"> <i class="Hui-iconfont">&#xe68f;</i></a> &nbsp;&nbsp; &nbsp;<a class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px" href="employ/getAllEmploy.action" title="返回"> <i class="Hui-iconfont">&#xe66b;</i></a>
	</nav>
	<article class="page-container">
		<form class="form form-horizontal" id="form-article-add" action="employ/personal.action" name="myform" method="post">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">员工号</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="eno" class="input-text" id="eno" value="${employ.eno}" readonly="readonly" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">姓名</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="employname" class="input-text" id="employname" value="${employ.employname}" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">性别</label>
				<div class="formControls col-xs-8 col-sm-9">
					<span class="select-box">${employ.sex}</span>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">出生日期</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="birthday" class="input-text" id="birthday" value="${employ.birthday}" onclick="WdatePicker()"
						readonly="readonly" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">籍贯</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="jiguan" class="input-text" id="jiguan" value="${employ.jiguan}" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">身份证</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="idcard" class="input-text" id="idcard" value="${employ.idcard}" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">联系方式</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="contact" class="input-text" id="contact" value="${employ.contact}" />
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
					<input type="hidden" name="employid" id="employid" value="${employ.employid}" /><input type="hidden" name="status" id="status"
						value="${employ.status}" /> <input type="hidden" name="addtime" id="addtime" value="${employ.addtime}" /> <input type="hidden"
						name="password" id="password" value="${employ.password}" /><input type="hidden" id="basepath" value="<%=basePath%>" /> <input
						type="hidden" name="sex" id="sex" value="${employ.sex}" /> <input type="hidden" name="salary" id="salary" value="${employ.salary}" />

					<button id="sub" class="btn btn-secondary radius" type="submit">
						<i class="Hui-iconfont">&#xe632;</i>提交保存
					</button>
					<button id="res" class="btn btn-default radius" type="reset">
						<i class="Hui-iconfont">&#xe68f;</i>取消重置
					</button>
				</div>
			</div>
		</form>
	</article>
</body>
</html>


