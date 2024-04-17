$(function() {

$("#ordercode").blur(
		function() {
			$("#ordercode_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#ordercode").after("<span id='ordercode_msg' style='color: red'>订单号不能为空</span>");
			}
	});

$("#usersid").blur(
		function() {
			$("#usersid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
			}
	});

$("#employid").blur(
		function() {
			$("#employid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#employid").after("<span id='employid_msg' style='color: red'>服务员不能为空</span>");
			}
	});

$("#tabxid").blur(
		function() {
			$("#tabxid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#tabxid").after("<span id='tabxid_msg' style='color: red'>餐桌不能为空</span>");
			}
	});

$("#orderdate").blur(
		function() {
			$("#orderdate_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#orderdate").after("<span id='orderdate_msg' style='color: red'>预定日期不能为空</span>");
			}
	});







$('#sub').click(function(){
var ordercode = $("#ordercode").val();
var usersid = $("#usersid").val();
var employid = $("#employid").val();
var tabxid = $("#tabxid").val();
var orderdate = $("#orderdate").val();
$("#ordercode_msg").empty();
$("#usersid_msg").empty();
$("#employid_msg").empty();
$("#tabxid_msg").empty();
$("#orderdate_msg").empty();
if (ordercode == "" || ordercode == null) {
	$("#ordercode").after("<span id='ordercode_msg' style='color: red'>订单号不能为空</span>");
	return false;
}
if (usersid == "" || usersid == null) {
	$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
	return false;
}
if (employid == "" || employid == null) {
	$("#employid").after("<span id='employid_msg' style='color: red'>服务员不能为空</span>");
	return false;
}
if (tabxid == "" || tabxid == null) {
	$("#tabxid").after("<span id='tabxid_msg' style='color: red'>餐桌不能为空</span>");
	return false;
}
if (orderdate == "" || orderdate == null) {
	$("#orderdate").after("<span id='orderdate_msg' style='color: red'>预定日期不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#ordercode_msg").empty();
$("#usersid_msg").empty();
$("#employid_msg").empty();
$("#tabxid_msg").empty();
$("#orderdate_msg").empty();
});

});
