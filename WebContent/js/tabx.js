$(function() {

$("#tabxname").blur(
		function() {
			$("#tabxname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#tabxname").after("<span id='tabxname_msg' style='color: red'>餐桌名称不能为空</span>");
			}
	});

$("#image").blur(
		function() {
			$("#image_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#image").after("<span id='image_msg' style='color: red'>图片不能为空</span>");
			}
	});

$("#num").blur(
		function() {
			$("#num_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#num").after("<span id='num_msg' style='color: red'>用餐人数不能为空</span>");
			}
	});

$("#place").blur(
		function() {
			$("#place_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#place").after("<span id='place_msg' style='color: red'>餐桌位置不能为空</span>");
			}
	});

$("#contents").blur(
		function() {
			$("#contents_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contents").after("<span id='contents_msg' style='color: red'>餐桌介绍不能为空</span>");
			}
	});







$('#sub').click(function(){
var tabxname = $("#tabxname").val();
var image = $("#image").val();
var num = $("#num").val();
var place = $("#place").val();
var contents = $("#contents").val();
$("#tabxname_msg").empty();
$("#image_msg").empty();
$("#num_msg").empty();
$("#place_msg").empty();
$("#contents_msg").empty();
if (tabxname == "" || tabxname == null) {
	$("#tabxname").after("<span id='tabxname_msg' style='color: red'>餐桌名称不能为空</span>");
	return false;
}
if (image == "" || image == null) {
	$("#image").after("<span id='image_msg' style='color: red'>图片不能为空</span>");
	return false;
}
if (num == "" || num == null) {
	$("#num").after("<span id='num_msg' style='color: red'>用餐人数不能为空</span>");
	return false;
}
if (place == "" || place == null) {
	$("#place").after("<span id='place_msg' style='color: red'>餐桌位置不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>餐桌介绍不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#tabxname_msg").empty();
$("#image_msg").empty();
$("#num_msg").empty();
$("#place_msg").empty();
$("#contents_msg").empty();
});

});
