$(function() {

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
				$("#num").after("<span id='num_msg' style='color: red'>浏览次数不能为空</span>");
			}
	});







$('#sub').click(function(){
var usersid = $("#usersid").val();
var foodsid = $("#foodsid").val();
var num = $("#num").val();
$("#usersid_msg").empty();
$("#foodsid_msg").empty();
$("#num_msg").empty();
if (usersid == "" || usersid == null) {
	$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
	return false;
}
if (foodsid == "" || foodsid == null) {
	$("#foodsid").after("<span id='foodsid_msg' style='color: red'>食品不能为空</span>");
	return false;
}
if (num == "" || num == null) {
	$("#num").after("<span id='num_msg' style='color: red'>浏览次数不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#usersid_msg").empty();
$("#foodsid_msg").empty();
$("#num_msg").empty();
});

});
