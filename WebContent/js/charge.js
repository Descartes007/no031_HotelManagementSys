$(function() {

$("#cno").blur(
		function() {
			$("#cno_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cno").after("<span id='cno_msg' style='color: red'>消费单号不能为空</span>");
			}
	});

$("#ordersid").blur(
		function() {
			$("#ordersid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#ordersid").after("<span id='ordersid_msg' style='color: red'>订单不能为空</span>");
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

$("#total").blur(
		function() {
			$("#total_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#total").after("<span id='total_msg' style='color: red'>总计不能为空</span>");
			}
	});







$('#sub').click(function(){
var cno = $("#cno").val();
var ordersid = $("#ordersid").val();
var usersid = $("#usersid").val();
var total = $("#total").val();
$("#cno_msg").empty();
$("#ordersid_msg").empty();
$("#usersid_msg").empty();
$("#total_msg").empty();
if (cno == "" || cno == null) {
	$("#cno").after("<span id='cno_msg' style='color: red'>消费单号不能为空</span>");
	return false;
}
if (ordersid == "" || ordersid == null) {
	$("#ordersid").after("<span id='ordersid_msg' style='color: red'>订单不能为空</span>");
	return false;
}
if (usersid == "" || usersid == null) {
	$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
	return false;
}
if (total == "" || total == null) {
	$("#total").after("<span id='total_msg' style='color: red'>总计不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#cno_msg").empty();
$("#ordersid_msg").empty();
$("#usersid_msg").empty();
$("#total_msg").empty();
});

});
