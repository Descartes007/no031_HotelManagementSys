$(function() {

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

$("#foodsid").blur(
		function() {
			$("#foodsid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#foodsid").after("<span id='foodsid_msg' style='color: red'>食品不能为空</span>");
			}
	});

$("#num").blur(
		function() {
			$("#num_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#num").after("<span id='num_msg' style='color: red'>评分不能为空</span>");
			}
	});

$("#contents").blur(
		function() {
			$("#contents_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contents").after("<span id='contents_msg' style='color: red'>内容不能为空</span>");
			}
	});







$('#sub').click(function(){
var ordersid = $("#ordersid").val();
var usersid = $("#usersid").val();
var foodsid = $("#foodsid").val();
var num = $("#num").val();
var contents = $("#contents").val();
$("#ordersid_msg").empty();
$("#usersid_msg").empty();
$("#foodsid_msg").empty();
$("#num_msg").empty();
$("#contents_msg").empty();
if (ordersid == "" || ordersid == null) {
	$("#ordersid").after("<span id='ordersid_msg' style='color: red'>订单不能为空</span>");
	return false;
}
if (usersid == "" || usersid == null) {
	$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
	return false;
}
if (foodsid == "" || foodsid == null) {
	$("#foodsid").after("<span id='foodsid_msg' style='color: red'>食品不能为空</span>");
	return false;
}
if (num == "" || num == null) {
	$("#num").after("<span id='num_msg' style='color: red'>评分不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>内容不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#ordersid_msg").empty();
$("#usersid_msg").empty();
$("#foodsid_msg").empty();
$("#num_msg").empty();
$("#contents_msg").empty();
});

});
