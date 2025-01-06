/**
 * checkInputUser2.js
 */
$(function(){
	$("#frmm").submit(function(){
		if($("#userName").val().trim() === ""){
			alert("이름을 입력해주세요");
			$("#userName").focus();
			return false;
		}
		if($("#userBirth").val().trim() === ""){
			alert("생년월일을 입력해주세요");
			$("#userBirth").focus();
			return false;
		}
		if($("#sample4_roadAddress").val().trim() === ""){
			alert("주소를 입력해주세요");
			$("#sample4_roadAddress").focus();
			return false;
		}
		
		/*var pattern=/^[0-9]$/;*/
		if($("#userPhone").val().trim() === ""){
			alert("전화번호를 입력해주세요");
			$("#userPhone").focus();
			return false;
		}/*else if($("#userPhone").val()!=pattern){
			alert("");
			return false;
		}*/
		
		if($("#userEmail").val().trim() === ""){
			alert("이메일을 입력해주세요");
			$("#userEmail").focus();
			return false;
		}
	});
	
});