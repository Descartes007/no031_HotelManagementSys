$(function() {

$("#roomsno").blur(
		function() {
			$("#roomsno_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#roomsno").after("<span id='roomsno_msg' style='color: red'>房间号不能为空</span>");
			}
	});

$("#image").blur(
		function() {
			$("#image_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#image").after("<span id='image_msg' style='color: red'>客房图片不能为空</span>");
			}
	});

$("#price").blur(
		function() {
			$("#price_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#price").after("<span id='price_msg' style='color: red'>客房价格不能为空</span>");
			}
	});

$("#mianji").blur(
		function() {
			$("#mianji_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#mianji").after("<span id='mianji_msg' style='color: red'>客房面积不能为空</span>");
			}
	});

$("#chaoxiang").blur(
		function() {
			$("#chaoxiang_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#chaoxiang").after("<span id='chaoxiang_msg' style='color: red'>客房朝向不能为空</span>");
			}
	});

$("#contents").blur(
		function() {
			$("#contents_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contents").after("<span id='contents_msg' style='color: red'>客房介绍不能为空</span>");
			}
	});







$('#sub').click(function(){
var roomsno = $("#roomsno").val();
var image = $("#image").val();
var price = $("#price").val();
var mianji = $("#mianji").val();
var chaoxiang = $("#chaoxiang").val();
var contents = $("#contents").val();
$("#roomsno_msg").empty();
$("#image_msg").empty();
$("#price_msg").empty();
$("#mianji_msg").empty();
$("#chaoxiang_msg").empty();
$("#contents_msg").empty();
if (roomsno == "" || roomsno == null) {
	$("#roomsno").after("<span id='roomsno_msg' style='color: red'>房间号不能为空</span>");
	return false;
}
if (image == "" || image == null) {
	$("#image").after("<span id='image_msg' style='color: red'>客房图片不能为空</span>");
	return false;
}
if (price == "" || price == null) {
	$("#price").after("<span id='price_msg' style='color: red'>客房价格不能为空</span>");
	return false;
}
if (mianji == "" || mianji == null) {
	$("#mianji").after("<span id='mianji_msg' style='color: red'>客房面积不能为空</span>");
	return false;
}
if (chaoxiang == "" || chaoxiang == null) {
	$("#chaoxiang").after("<span id='chaoxiang_msg' style='color: red'>客房朝向不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>客房介绍不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#roomsno_msg").empty();
$("#image_msg").empty();
$("#price_msg").empty();
$("#mianji_msg").empty();
$("#chaoxiang_msg").empty();
$("#contents_msg").empty();
});

});
