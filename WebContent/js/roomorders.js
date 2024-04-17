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

$("#roomsid").blur(
		function() {
			$("#roomsid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#roomsid").after("<span id='roomsid_msg' style='color: red'>客房不能为空</span>");
			}
	});

$("#thestart").blur(
		function() {
			$("#thestart_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#thestart").after("<span id='thestart_msg' style='color: red'>开始日期不能为空</span>");
			}
	});

$("#theend").blur(
		function() {
			$("#theend_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#theend").after("<span id='theend_msg' style='color: red'>结束日期不能为空</span>");
			}
	});

$("#memo").blur(
		function() {
			$("#memo_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
			}
	});







$('#sub').click(function(){
var ordercode = $("#ordercode").val();
var usersid = $("#usersid").val();
var roomsid = $("#roomsid").val();
var thestart = $("#thestart").val();
var theend = $("#theend").val();
var memo = $("#memo").val();
$("#ordercode_msg").empty();
$("#usersid_msg").empty();
$("#roomsid_msg").empty();
$("#thestart_msg").empty();
$("#theend_msg").empty();
$("#memo_msg").empty();
if (ordercode == "" || ordercode == null) {
	$("#ordercode").after("<span id='ordercode_msg' style='color: red'>订单号不能为空</span>");
	return false;
}
if (usersid == "" || usersid == null) {
	$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
	return false;
}
if (roomsid == "" || roomsid == null) {
	$("#roomsid").after("<span id='roomsid_msg' style='color: red'>客房不能为空</span>");
	return false;
}
if (thestart == "" || thestart == null) {
	$("#thestart").after("<span id='thestart_msg' style='color: red'>开始日期不能为空</span>");
	return false;
}
if (theend == "" || theend == null) {
	$("#theend").after("<span id='theend_msg' style='color: red'>结束日期不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#ordercode_msg").empty();
$("#usersid_msg").empty();
$("#roomsid_msg").empty();
$("#thestart_msg").empty();
$("#theend_msg").empty();
$("#memo_msg").empty();
});

});
