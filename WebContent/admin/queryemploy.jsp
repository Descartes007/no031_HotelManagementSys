<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<% String path = request.getContextPath(); String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";%><!doctype html>
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
<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>员工管理 <span class="c-gray en">&gt;</span>
员工查询 <a class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="javascript:location.replace(location.href);" title="刷新">
<i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
<table class="table table-border table-bordered table-bg">
<thead><tr><th scope="col" colspan="11">员工查询</th></tr><tr class="text-c"><th class="center">员工号</th><th class="center">姓名</th><th class="center">性别</th><th class="center">出生日期</th><th class="center">籍贯</th><th class="center">身份证</th><th class="center">薪资</th><th class="center">联系方式</th><th class="center">状态</th><th class="center">创建日期</th></tr></thead>
<c:forEach items="${employList}" var="employ"><tr class="text-c"><td class="center">${employ.eno}</td><td class="center">${employ.employname}</td><td class="center">${employ.sex}</td><td class="center">${employ.birthday}</td><td class="center">${employ.jiguan}</td><td class="center">${employ.idcard}</td><td class="center">${employ.salary}</td><td class="center">${employ.contact}</td><td class="center">${employ.status}</td><td class="center">${employ.addtime}</td></tr></c:forEach></table>
<div class="cl pd-5 mt-20"></div>
<div class="text-c">
<form action="employ/queryEmployByCond.action" name="myform" method="post">
查询条件： <span class="select-box" style="width: 200px;"><select name="cond" class="select">
<option value="eno">按员工号查询</option><option value="employname">按姓名查询</option><option value="sex">按性别查询</option><option value="birthday">按出生日期查询</option><option value="jiguan">按籍贯查询</option><option value="idcard">按身份证查询</option><option value="salary">按薪资查询</option><option value="contact">按联系方式查询</option><option value="status">按状态查询</option><option value="addtime">按创建日期查询</option></select></span>&nbsp;&nbsp;关键字<input type="text" name="name" required style="width: 200px" class="input-text" />
<button type="submit" class="btn btn-success radius">
<i class="Hui-iconfont">&#xe665;</i> 查询
</button>
</form>
</div>
</div>
</body>
</html>

