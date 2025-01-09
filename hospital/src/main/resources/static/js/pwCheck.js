/**
 * pwCheck.js
 */
$(function(){
	$("#frm").submit(function(){
		if($("#newPw").val().trim()===""){
			alert("변경할 비밀번호를 입력하여주세요");
			$("#newPw").focus();
			return false;
	
		}
		if($("#newPwCon").val().trim()===""){
			alert("비밀번호확인을 입력여주세요");
			$("#newPwCon").focus();
			return false;
		}
		if($("#newPw").val()!=$("#newPwCon").val()){
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.")
			$("#newPw").val("");
			$("#newPwCon").val("");
			$("#newPw").focus();
			return false;
		}
	});
	$("#frmm").submit(function(){
		if($("#userPwCon").val().trim() === ""){
			alert("현재 비밀번호를 입력해주세요");
			$("#userPwCon").focus();
			return false;
		}
	});
});