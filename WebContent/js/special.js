$(function() {

$("#foodsid").blur(
		function() {
			$("#foodsid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#foodsid").after("<span id='foodsid_msg' style='color: red'>食品不能为空</span>");
			}
	});

$("#nowprice").blur(
		function() {
			$("#nowprice_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#nowprice").after("<span id='nowprice_msg' style='color: red'>价格不能为空</span>");
			}
	});

$("#addtime").blur(
		function() {
			$("#addtime_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#addtime").after("<span id='addtime_msg' style='color: red'>特价日期不能为空</span>");
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
var foodsid = $("#foodsid").val();
var nowprice = $("#nowprice").val();
var addtime = $("#addtime").val();
var memo = $("#memo").val();
$("#foodsid_msg").empty();
$("#nowprice_msg").empty();
$("#addtime_msg").empty();
$("#memo_msg").empty();
if (foodsid == "" || foodsid == null) {
	$("#foodsid").after("<span id='foodsid_msg' style='color: red'>食品不能为空</span>");
	return false;
}
if (nowprice == "" || nowprice == null) {
	$("#nowprice").after("<span id='nowprice_msg' style='color: red'>价格不能为空</span>");
	return false;
}
if (addtime == "" || addtime == null) {
	$("#addtime").after("<span id='addtime_msg' style='color: red'>特价日期不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#foodsid_msg").empty();
$("#nowprice_msg").empty();
$("#addtime_msg").empty();
$("#memo_msg").empty();
});

});
