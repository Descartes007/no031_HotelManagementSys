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
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>员工管理 <span class="c-gray en">&gt;</span> 新增员工 <a
			class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="employ/createEmploy.action" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<article class="page-container">
		<form class="form form-horizontal" id="form-article-add" action="employ/addEmploy.action" name="myform" method="post">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">员工号</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="eno" class="input-text" id="eno" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">密码</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="password" name="password" class="input-text" id="password" placeholder="请输入密码" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">姓名</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="employname" class="input-text" id="employname" placeholder="请输入姓名" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">性别</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="radio" name="sex" value="男" title="男">男 &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="女" title="女"
						checked>女
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">出生日期</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="birthday" class="input-text" id="birthday" onclick="WdatePicker()" readonly="readonly" placeholder="请输入出生日期" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">籍贯</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="jiguan" class="input-text" id="jiguan" placeholder="请输入籍贯" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">身份证</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="idcard" class="input-text" id="idcard" placeholder="请输入身份证" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">薪资</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="salary" class="input-text" id="salary" placeholder="请输入薪资" />
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">联系方式</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" name="contact" class="input-text" id="contact" placeholder="请输入联系方式" />
				</div>
			</div>

			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
					<input type="hidden" id="basepath" value="<%=basePath%>" />
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

