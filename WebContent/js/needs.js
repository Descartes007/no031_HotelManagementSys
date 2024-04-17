$(function() {

$("#goodsname").blur(
		function() {
			$("#goodsname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#goodsname").after("<span id='goodsname_msg' style='color: red'>需求不能为空</span>");
			}
	});

$("#reps").blur(
		function() {
			$("#reps_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#reps").after("<span id='reps_msg' style='color: red'>管理员回复不能为空</span>");
			}
	});







$('#sub').click(function(){
var goodsname = $("#goodsname").val();
var reps = $("#reps").val();
$("#goodsname_msg").empty();
$("#reps_msg").empty();
if (goodsname == "" || goodsname == null) {
	$("#goodsname").after("<span id='goodsname_msg' style='color: red'>需求不能为空</span>");
	return false;
}
if (reps == "" || reps == null) {
	$("#reps").after("<span id='reps_msg' style='color: red'>管理员回复不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#goodsname_msg").empty();
$("#reps_msg").empty();
});

});
