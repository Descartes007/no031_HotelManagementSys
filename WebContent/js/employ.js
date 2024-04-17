$(function() {

$("#eno").blur(
		function() {
			$("#eno_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#eno").after("<span id='eno_msg' style='color: red'>员工号不能为空</span>");
			}
	});

$("#employname").blur(
		function() {
			$("#employname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#employname").after("<span id='employname_msg' style='color: red'>姓名不能为空</span>");
			}
	});

$("#birthday").blur(
		function() {
			$("#birthday_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#birthday").after("<span id='birthday_msg' style='color: red'>出生日期不能为空</span>");
			}
	});

$("#jiguan").blur(
		function() {
			$("#jiguan_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#jiguan").after("<span id='jiguan_msg' style='color: red'>籍贯不能为空</span>");
			}
	});

$("#idcard").blur(
		function() {
			$("#idcard_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#idcard").after("<span id='idcard_msg' style='color: red'>身份证不能为空</span>");
			}
	});

$("#salary").blur(
		function() {
			$("#salary_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#salary").after("<span id='salary_msg' style='color: red'>薪资不能为空</span>");
			}
	});

$("#contact").blur(
		function() {
			$("#contact_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contact").after("<span id='contact_msg' style='color: red'>联系方式不能为空</span>");
			}
	});







$('#sub').click(function(){
var eno = $("#eno").val();
var employname = $("#employname").val();
var birthday = $("#birthday").val();
var jiguan = $("#jiguan").val();
var idcard = $("#idcard").val();
var salary = $("#salary").val();
var contact = $("#contact").val();
$("#eno_msg").empty();
$("#employname_msg").empty();
$("#birthday_msg").empty();
$("#jiguan_msg").empty();
$("#idcard_msg").empty();
$("#salary_msg").empty();
$("#contact_msg").empty();
if (eno == "" || eno == null) {
	$("#eno").after("<span id='eno_msg' style='color: red'>员工号不能为空</span>");
	return false;
}
if (employname == "" || employname == null) {
	$("#employname").after("<span id='employname_msg' style='color: red'>姓名不能为空</span>");
	return false;
}
if (birthday == "" || birthday == null) {
	$("#birthday").after("<span id='birthday_msg' style='color: red'>出生日期不能为空</span>");
	return false;
}
if (jiguan == "" || jiguan == null) {
	$("#jiguan").after("<span id='jiguan_msg' style='color: red'>籍贯不能为空</span>");
	return false;
}
if (idcard == "" || idcard == null) {
	$("#idcard").after("<span id='idcard_msg' style='color: red'>身份证不能为空</span>");
	return false;
}
if (salary == "" || salary == null) {
	$("#salary").after("<span id='salary_msg' style='color: red'>薪资不能为空</span>");
	return false;
}
if (contact == "" || contact == null) {
	$("#contact").after("<span id='contact_msg' style='color: red'>联系方式不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#eno_msg").empty();
$("#employname_msg").empty();
$("#birthday_msg").empty();
$("#jiguan_msg").empty();
$("#idcard_msg").empty();
$("#salary_msg").empty();
$("#contact_msg").empty();
});

});
