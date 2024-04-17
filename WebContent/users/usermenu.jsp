<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div class="userMenu">
	
	<a href="index/usercenter.action"><img src="themes/ecmoban_dangdang/images/u2.gif" />用户中心</a> 
	<a href="index/userinfo.action"><img src="themes/ecmoban_dangdang/images/u2.gif" />用户信息</a> 
	<a href="index/prePwd.action"><img src="themes/ecmoban_dangdang/images/u3.gif" />修改密码</a> 
	<a href="index/showOrders.action"><img src="themes/ecmoban_dangdang/images/u3.gif" />我的餐饮订单</a> 
	<a href="index/roomorders.action"><img src="themes/ecmoban_dangdang/images/u3.gif" />我的客房订单</a> 
	<a href="index/myCharge.action"><img src="themes/ecmoban_dangdang/images/u3.gif" />我的付款记录</a>
	<a href="index/preComplains.action"><img src="themes/ecmoban_dangdang/images/u3.gif" />意见反馈</a>
	<a href="index/myComplains.action"><img src="themes/ecmoban_dangdang/images/u3.gif" />我的意见反馈</a>
	<a href="index/preNeeds.action"><img src="themes/ecmoban_dangdang/images/u3.gif" />客户需求</a>
	<a href="index/myNeeds.action"><img src="themes/ecmoban_dangdang/images/u3.gif" />我的需求</a>
	<a href="index/exit.action" style="background: none; text-align: right; margin-right: 10px;"> <img
		src="themes/ecmoban_dangdang/images/bnt_sign.gif" /></a>
</div>
