$(function() {

$("#bno").blur(
		function() {
			$("#bno_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#bno").after("<span id='bno_msg' style='color: red'>采购单号不能为空</span>");
			}
	});

$("#goodsname").blur(
		function() {
			$("#goodsname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#goodsname").after("<span id='goodsname_msg' style='color: red'>采购货物不能为空</span>");
			}
	});

$("#price").blur(
		function() {
			$("#price_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#price").after("<span id='price_msg' style='color: red'>采购单价不能为空</span>");
			}
	});

$("#num").blur(
		function() {
			$("#num_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#num").after("<span id='num_msg' style='color: red'>采购数量不能为空</span>");
			}
	});

$("#manager").blur(
		function() {
			$("#manager_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#manager").after("<span id='manager_msg' style='color: red'>经手人不能为空</span>");
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
var bno = $("#bno").val();
var goodsname = $("#goodsname").val();
var price = $("#price").val();
var num = $("#num").val();
var manager = $("#manager").val();
var memo = $("#memo").val();
$("#bno_msg").empty();
$("#goodsname_msg").empty();
$("#price_msg").empty();
$("#num_msg").empty();
$("#manager_msg").empty();
$("#memo_msg").empty();
if (bno == "" || bno == null) {
	$("#bno").after("<span id='bno_msg' style='color: red'>采购单号不能为空</span>");
	return false;
}
if (goodsname == "" || goodsname == null) {
	$("#goodsname").after("<span id='goodsname_msg' style='color: red'>采购货物不能为空</span>");
	return false;
}
if (price == "" || price == null) {
	$("#price").after("<span id='price_msg' style='color: red'>采购单价不能为空</span>");
	return false;
}
if (num == "" || num == null) {
	$("#num").after("<span id='num_msg' style='color: red'>采购数量不能为空</span>");
	return false;
}
if (manager == "" || manager == null) {
	$("#manager").after("<span id='manager_msg' style='color: red'>经手人不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#bno_msg").empty();
$("#goodsname_msg").empty();
$("#price_msg").empty();
$("#num_msg").empty();
$("#manager_msg").empty();
$("#memo_msg").empty();
});

});
