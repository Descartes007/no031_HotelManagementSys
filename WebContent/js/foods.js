$(function() {

$("#foodsname").blur(
		function() {
			$("#foodsname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#foodsname").after("<span id='foodsname_msg' style='color: red'>食品名称不能为空</span>");
			}
	});

$("#image").blur(
		function() {
			$("#image_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#image").after("<span id='image_msg' style='color: red'>食品图片不能为空</span>");
			}
	});

$("#cateid").blur(
		function() {
			$("#cateid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cateid").after("<span id='cateid_msg' style='color: red'>食品类型不能为空</span>");
			}
	});

$("#price").blur(
		function() {
			$("#price_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#price").after("<span id='price_msg' style='color: red'>食品单价不能为空</span>");
			}
	});

$("#contents").blur(
		function() {
			$("#contents_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contents").after("<span id='contents_msg' style='color: red'>食品介绍不能为空</span>");
			}
	});







$('#sub').click(function(){
var foodsname = $("#foodsname").val();
var image = $("#image").val();
var cateid = $("#cateid").val();
var price = $("#price").val();
var contents = $("#contents").val();
$("#foodsname_msg").empty();
$("#image_msg").empty();
$("#cateid_msg").empty();
$("#price_msg").empty();
$("#contents_msg").empty();
if (foodsname == "" || foodsname == null) {
	$("#foodsname").after("<span id='foodsname_msg' style='color: red'>食品名称不能为空</span>");
	return false;
}
if (image == "" || image == null) {
	$("#image").after("<span id='image_msg' style='color: red'>食品图片不能为空</span>");
	return false;
}
if (cateid == "" || cateid == null) {
	$("#cateid").after("<span id='cateid_msg' style='color: red'>食品类型不能为空</span>");
	return false;
}
if (price == "" || price == null) {
	$("#price").after("<span id='price_msg' style='color: red'>食品单价不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>食品介绍不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#foodsname_msg").empty();
$("#image_msg").empty();
$("#cateid_msg").empty();
$("#price_msg").empty();
$("#contents_msg").empty();
});

});
