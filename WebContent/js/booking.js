$(function() {

$("#bno").blur(
		function() {
			$("#bno_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#bno").after("<span id='bno_msg' style='color: red'>收支单号不能为空</span>");
			}
	});

$("#cate").blur(
		function() {
			$("#cate_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cate").after("<span id='cate_msg' style='color: red'>收支类型不能为空</span>");
			}
	});

$("#reason").blur(
		function() {
			$("#reason_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#reason").after("<span id='reason_msg' style='color: red'>收支原因不能为空</span>");
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

$("#addtime").blur(
		function() {
			$("#addtime_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#addtime").after("<span id='addtime_msg' style='color: red'>日期不能为空</span>");
			}
	});







$('#sub').click(function(){
var bno = $("#bno").val();
var cate = $("#cate").val();
var reason = $("#reason").val();
var total = $("#total").val();
var addtime = $("#addtime").val();
$("#bno_msg").empty();
$("#cate_msg").empty();
$("#reason_msg").empty();
$("#total_msg").empty();
$("#addtime_msg").empty();
if (bno == "" || bno == null) {
	$("#bno").after("<span id='bno_msg' style='color: red'>收支单号不能为空</span>");
	return false;
}
if (cate == "" || cate == null) {
	$("#cate").after("<span id='cate_msg' style='color: red'>收支类型不能为空</span>");
	return false;
}
if (reason == "" || reason == null) {
	$("#reason").after("<span id='reason_msg' style='color: red'>收支原因不能为空</span>");
	return false;
}
if (total == "" || total == null) {
	$("#total").after("<span id='total_msg' style='color: red'>总计不能为空</span>");
	return false;
}
if (addtime == "" || addtime == null) {
	$("#addtime").after("<span id='addtime_msg' style='color: red'>日期不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#bno_msg").empty();
$("#cate_msg").empty();
$("#reason_msg").empty();
$("#total_msg").empty();
$("#addtime_msg").empty();
});

});
